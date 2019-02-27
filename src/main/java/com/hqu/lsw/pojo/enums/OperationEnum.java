package com.hqu.lsw.pojo.enums;

/**
 * @Description 操作类型枚举
 * @Author shengwei.liu@luckincoffee.com
 * @Date 2019/2/27
 */
public enum OperationEnum {

    /**
     * 新增
     */
    NEW(1,"新增"),

    /**
     * 修改
     */
    MOD(2,"修改"),

    /**
     * 删除
     */
    DELETE(5,"删除");

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
     *
     * @param index 索引
     * @param name 值
     */
    OperationEnum(Integer index, String name){
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
        for (OperationEnum c : OperationEnum.values()) {
            if (c.getIndex().equals(index)) {
                return c.name;
            }
        }
        return null;
    }
}
