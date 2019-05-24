package com.hqu.lsw.small.Enum;

/**
 * @Description 结果美剧
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/4/24 19:59
 */
public enum ResultCode {

    PASSWORD_ERROR(100,"密码错误"),

    EXIST(101,"用户存在"),

    SUCCESS(200,"成功"),

    FAIL(500,"失败");

    private Integer code;

    private String message;


    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取
     *
     * @return code
     */
    public Integer getCode() {
        return this.code;
    }

    /**
     * 设置
     *
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 获取
     *
     * @return message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * 设置
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
