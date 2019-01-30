package com.db.ssm.common.Utli;

import com.db.ssm.common.vo.PageObject;
import java.util.List;

public class PageUtil {
	public static <T>PageObject<T> pageObject(
	    		      int rowCount,List<T> records,
	    		      int pageCurrent,int pageSize){
	    	PageObject<T> pageObject = new PageObject<>();
			pageObject.setRowCount(rowCount);
			pageObject.setRecords(records);
			pageObject.setPageSize(pageSize);
			pageObject.setPageCurrent(pageCurrent);
			pageObject.setPageCount((rowCount-1)/pageSize+1);
	    	return pageObject;
	    }
}
