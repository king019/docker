package com.k.docker.jenkins.model.emums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
public enum DockerFunctionEnum {
    ONLY_LOCAL("only_local");
    private String function;

    DockerFunctionEnum(String function) {
        this.function = function;
    }
    public static DockerFunctionEnum getFunction(String function){
        for (DockerFunctionEnum value : DockerFunctionEnum.values()) {

            if(value.getFunction().equals(function)){return value;}
        }return null;
    }public static Set<DockerFunctionEnum>  getFunctions(Set<String> functions){
        return functions.stream().map(DockerFunctionEnum::getFunction).collect(Collectors.toSet());
    }
}
