package com.hqu.lsw.small.exception;

/**
 * @Description 自定义业务异常
 * @Author 刘圣伟 shengwei.liu@luckincoffee.com
 * @Date 2019/4/23 20:03
 */
public class BusinessException extends Exception{

    private static final long serialVersionUID = 3387116828418332189L;

    public BusinessException(){
        super();
    }

    public BusinessException(String message){
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }
}
