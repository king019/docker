package com.k.docker.jenkins.model.emums.constant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CopyTypeEnum {
    copy_file(1),
    copy_txt(2),
//    use_src(3),
    ;
    private int type;

    public static CopyTypeEnum def() {
        return copy_txt;
    }
}
