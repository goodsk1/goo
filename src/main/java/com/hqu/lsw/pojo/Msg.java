package com.hqu.lsw.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 封装result返回前端
 * @Author shengwei.liu@ luckincoffee.com
 * @Date 2019/2/15
 */
public class Msg {
    /**
     * 操作的状态码（100-成功，200-失败）
     */
    private int code;

    /**
     * 操作的描述信息
     */
    private String msg;

    /**
     * 用于封装一个对象
     */
    private Object tag;


    /**
     * 用于封装一个map键值对
     */
    private Map<String, Object> extend = new HashMap<String, Object>();


    public Object getTag() {
        return tag;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }


    /**
     * 直接返回操作成功
     * @return
     */
    public static Msg success() {
        Msg result = new Msg();
        result.setCode(100);
        result.setMsg("成功");
        return result;
    }

    /**
     * 直接返回操作失败
     * @return
     */
    public static Msg fail() {
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg("失败");
        return result;
    }

    /**
     * 把健值对象加入extend中
     * @param key
     * @param value
     * @return
     */
    public Msg add(String key, Object value) {
        this.getExtend().put(key, value);
        return this;
    }

}
