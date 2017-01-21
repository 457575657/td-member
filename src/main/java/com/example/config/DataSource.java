/**   
* @Title: DataSource.java
* @Package com.niiwoo.dao.annotation
* @Description: TODO(用一句话描述该文件做什么)
* @author seven   
* @date 2014-10-14 上午9:19:33
* @version V1.0   
*/


package com.example.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

 
@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD) 
public @interface DataSource {
	String value(); 
}
