package com.db.ssm.common.Utli;


import com.db.ssm.pojo.User;
import org.apache.shiro.SecurityUtils;

public class ShiroUtils {

	 public static User getUser(){
		return (User) SecurityUtils.getSubject().getPrincipal();
	 }

}
