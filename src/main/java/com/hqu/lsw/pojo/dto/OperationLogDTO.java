package com.hqu.lsw.pojo.dto;

import java.util.Date;

/**
 * @Description 操作记录DTO
 * @Author shengwei.liu@ luckincoffee.com
 * @Date 2019/2/22
 */
public class OperationLogDTO {

    /**
     * 表主键id
     */
    private Long tablePrimaryKey;

    /**
     * 操作类型
     */
    private String operType;

    /**
     * 备注
     */
    private String remark;

    /**
     * 操作人id
     */
    private Long createId;

    /**
     * 操作人姓名
     */
    private String createName;

    /**
     *操作时间
     */
    private Date createTime;

    /**
     * 功能
     */
    private Integer functionType;

    public Long getTablePrimaryKey() {
        return tablePrimaryKey;
    }

    public void setTablePrimaryKey(Long tablePrimaryKey) {
        this.tablePrimaryKey = tablePrimaryKey;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getFunctionType() {
        return functionType;
    }

    public void setFunctionType(Integer functionType) {
        this.functionType = functionType;
    }
}
