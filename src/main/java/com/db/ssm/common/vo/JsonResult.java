package com.db.ssm.common.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/1/20 0020 下午 9:00
 */
public class JsonResult implements Serializable {

    private static final long serialVersionUID = 419545449856515205L;
    /**状态码*/
    private int state = 1;//表示seccess,0表示error
    /**状态信息*/
    private String message = "ok" ;
    /**正确数据*/
    private Object data;

    public JsonResult() {}
    public JsonResult(String message){
        this.message=message;
    }
    /**一般查询时调用，封装查询结果*/
    public JsonResult(Object data) {
        this.data=data;
    }
    /**出现异常时时调用*/
    public JsonResult(Throwable t){
        this.state=0;
        this.message=t.getMessage();
    }
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}