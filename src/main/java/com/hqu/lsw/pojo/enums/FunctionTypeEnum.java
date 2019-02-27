package com.hqu.lsw.pojo.enums;

/**
 * @Description 日志记录功能类型枚举
 * @Author shengwei.liu@luckincoffee.com
 * @Date 2019/2/27
 */
public enum FunctionTypeEnum {

    /**
     * 厂家信息
     */
    MANUFACTOR_INFO(1,"厂家信息");

    /**
     * 索引
     */
    private Integer index;
    /**
     * name
     */
    private String name;

    /**
     * 构造
     * @param index 索引
     * @param name 值
     */
    FunctionTypeEnum(Integer index, String name){
        this.index = index;
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    /**
     * 根据索引获取名称
     *
     * @param index
     *            索引
     * @return name
     */
    public static String getNameByIndex(Integer index) {
        for (FunctionTypeEnum c : FunctionTypeEnum.values()) {
            if (c.getIndex().equals(index)) {
                return c.name;
            }
        }
        return null;
    }
}
