package com.db.ssm.common.exception;

/**
 * Created by Administrator on 2019/1/20 0020 下午 8:54
 */
public class ServiceException extends RuntimeException{
    private static final long serialVersionUID = 4845115428381042360L;

    public ServiceException(){
        super();
    }
    public ServiceException(String message) {
        super(message);
    }
    public ServiceException(Throwable cause) {
        super(cause);
    }


}
