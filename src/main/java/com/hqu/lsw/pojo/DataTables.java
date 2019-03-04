package com.hqu.lsw.pojo;

import java.util.List;


/**
 * @Description 返回查询的数据
 * @Author shengwei.liu
 * @Date 2018/12/3
 */
public class DataTables {

    /**
     * 查询结果返回的记录数
     */
    private int recordsTotal;

    /**
     *过滤后的总记录数
     */
    private int recordsFiltered;

    /**
     * 数据列表
     */
    private List data;

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
