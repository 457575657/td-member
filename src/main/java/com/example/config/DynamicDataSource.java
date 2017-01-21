/**   
* @Title: DynamicDataSource.java
* @Package com.niiwoo.dao.annotation
* @Description: TODO(用一句话描述该文件做什么)
* @author seven   
* @date 2014-10-14 上午9:32:33
* @version V1.0   
*/


package com.example.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

 

public class DynamicDataSource extends AbstractRoutingDataSource{
	
	@Override
	protected Object determineCurrentLookupKey() {
		System.out.println("========================== DynamicDataSource");
		 return HandleDataSource.getDataSource();  
	}

}
