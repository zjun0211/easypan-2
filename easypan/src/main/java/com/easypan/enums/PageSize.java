package com.easypan.enums;

/**
 * @author 王哲
 * @ClassName PageSize
 * @Description 创建基础类 代码生成器生成
 * @Version V1.0
 */

public enum PageSize {
    SIZE15(15), SIZE20(20), SIZE30(30), SIZE40(40), SIZE50(50);

    Integer size;

    public Integer getSize() {
        return this.size;
    }

    private PageSize(Integer size) {
        this.size = size;
    }
}
