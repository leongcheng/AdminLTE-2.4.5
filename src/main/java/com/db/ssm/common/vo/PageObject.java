package com.db.ssm.common.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/1/20 0020 下午 7:56
 */
public class PageObject<T> implements Serializable {
    private static final long serialVersionUID = -400909706811974563L;
    /**总记录数*/
    private Integer rowCount = 0;
    /**页面大小*/
    private Integer pageSize = 5;
    /**当前页码值*/
    private Integer pageCurrent = 1;
    /**总页数*/
    private Integer pageCount = 0;
    /**当前页记录*/
    private List<T> records;

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(Integer pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
