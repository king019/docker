package com.k.docker.jenkins;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.k.docker.jenkins.util.PathBaseUtil;
import com.k.docker.jenkins.util.PathUtil;
import com.k.docker.jenkins.util.model.DockerJenkinsModel;
import com.k.docker.jenkins.util.model.enums.BuildItemEnum;
import com.k.docker.jenkins.util.model.enums.DockerRegionEnum;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class JenkinsBuildShell {
    @Test
    public void test() throws Exception {
        String resource = PathUtil.getResource();
        File file = new File(resource);
        for (File listFile : Objects.requireNonNull(file.listFiles((dir, name) -> name.contains("x86") | name.contains("arm")))) {
            writeFirst(listFile);
        }
    }

    private void writeFirst(File file) throws Exception {
        Map<String, Map<BuildItemEnum, String>> map = Maps.newLinkedHashMap();
        readDir(file, map);
        String target = PathUtil.getTargetPath(file.getName() + ".txt");
        File targetFile = new File(target);
        List<String> sortIndex = sort(map);
        FileUtils.writeLines(targetFile, writeLines(map, sortIndex));
    }

    private List<String> sort(Map<String, Map<BuildItemEnum, String>> map) {
        List<String> sortIndex = Lists.newArrayList(map.keySet());
        Collections.sort(sortIndex, (o1, o2) -> {
            String index1 = map.get(o1).getOrDefault(BuildItemEnum.INDEX, BuildItemEnum.INDEX.getDef());
            String index2 = map.get(o2).getOrDefault(BuildItemEnum.INDEX, BuildItemEnum.INDEX.getDef());
            return NumberUtils.compare(Integer.parseInt(index1), Integer.parseInt(index2));
        });
        return sortIndex;
    }

    private List<String> writeLines(Map<String, Map<BuildItemEnum, String>> map, List<String> sortIndex) {
        List<String> lines = Lists.newArrayList();
        sortIndex.forEach(path -> {
            Map<BuildItemEnum, String> enumMap = map.get(path);
            if (Objects.nonNull(enumMap.get(BuildItemEnum.IGNORE))) {
                return;
            }
            DockerJenkinsModel model = new DockerJenkinsModel();
            model.setPath(path);
            model.setIndex(enumMap.getOrDefault(BuildItemEnum.INDEX, BuildItemEnum.INDEX.getDef()));
            model.setHost(DockerRegionEnum.getRegion(enumMap.get(BuildItemEnum.REGION)).getHost());
            String versions = enumMap.get(BuildItemEnum.VERSION);
            if (StringUtils.isBlank(versions)) {
                return;
            }
            model.setVersions(StringUtils.split(versions, ","));
            lines.add(model.toString());
        });


        return lines;
    }

    private void readDir(File file, Map<String, Map<BuildItemEnum, String>> map) throws Exception {
        if (Objects.isNull(file)) {
            return;
        }
        if (file.isFile()) {
            String name = file.getName();
            if (BuildItemEnum.ITEMS.contains(name)) {
                BuildItemEnum item = BuildItemEnum.getItem(name);
                String doc = StringUtils.join(FileUtils.readLines(file, StandardCharsets.UTF_8), ",");
                String path = file.getParentFile().getParentFile().getParentFile().getAbsolutePath();
                int prePathIndex = path.indexOf(PathBaseUtil.PRE_PATH);
                path = path.substring(prePathIndex);
                Map<BuildItemEnum, String> enumMap = map.computeIfAbsent(path, path1 -> Maps.newHashMap());
                enumMap.put(item, doc);
            }
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (Optional.ofNullable(files).isPresent()) {
                for (File fileInner : files) {
                    readDir(fileInner, map);
                }
            }
        }
    }
}
