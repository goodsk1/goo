package com.hqu.lsw.pojo;

/**
 * @Description
 * @Author shengwei.liu@ luckincoffee.com
 * @Date 2019/2/25
 */
public class Result<T> {
    /*
     * 状态码
     * */
    private int code;
    /*
     * 信息
     * */
    private String message;

    /*
     * 返回需要的值
     * */
    private T result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }


    /**
     * 返回失败状态码和信息
     *
     * @param code 状态码
     * @param message 成功信息
     * @param result 结果
     * @return  r 结果信息
     */
    public static Result success(int code,String message,Object result){
        Result r=new Result();
        r.setCode(code);
        r.setMessage(message);
        r.setResult(result);
        return r;
    }

    /**
     * 返回成功状态码和信息
     *
     * @param code 状态码
     * @param message 成功信息
     * @return  r 结果信息
     */
    public static Result success(int code,String message){
        Result r=new Result();
        r.setCode(code);
        r.setMessage(message);
        return r;
    }


    /**
     * 返回失败状态码和信息
     *
     * @param code 状态码
     * @param message 成功信息
     * @return  r 结果信息
     */
    public static Result fail(int code,String message){
        Result r=new Result();
        r.setCode(code);
        r.setMessage(message);
        return r;
    }
}

