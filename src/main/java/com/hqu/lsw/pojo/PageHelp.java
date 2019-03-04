package com.hqu.lsw.pojo;

import java.util.ArrayList;
import java.util.List;


/**
 * @Description 分页信息
 * @Author shengwei.liu
 * @Date 2018/12/3
 */
public class PageHelp<T> {

    /**
     * 页开始处
     */
    private int pageStart;

    /**
     * 页大小
     */
    private int pageSize;
    /**
     * 当前页号
     */
    private int pageIndex;
    /**
     * 记录数
     */
    private int record;
    /**
     * 用于返回集合数据
     */
    private List<T> List = new ArrayList<T>();


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRecord() {
        return record;
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageSize * pageIndex - pageSize;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public List<T> getList() {
        return List;
    }

    public void setList(List<T> list) {
        List = list;
    }

}
