package com.hqu.lsw.pojo.dto;

import java.io.Serializable;

/**
 * @description: 分页公用DTO
 * @author: chenzh zhihong.chen@luckincoffee.com
 * @date: 2018/11/5 11:25
 */
public class PageDTO implements Serializable {

    private static final long serialVersionUID = -2850087160132321723L;

    /**
     * 页码（从1开始）
     */
    private Integer pageNo;

    /**
     * 每页多少条
     */
    private Integer pageSize;

    /**
     * 偏移量
     */
    private Integer offset;

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        if(pageNo != null && pageSize != null){
            this.offset = (this.pageNo > 0 ? this.pageNo - 1 : 0) * this.pageSize;
            return offset;
        }else{
            return 0;
        }
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
