package com.example.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

//http://blog.csdn.net/mchange/article/details/50619710
@Configuration
public class DataSourceConfig {

    
    private final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);
    
    @Autowired
    private Environment env;
    
    @Bean(name = "writeDataSource")
    @Primary
    @ConfigurationProperties(prefix = "tdmember.master.jdbc")
    public DataSource writeDataSource() {
     logger.info("==================>init writeDataSource");
     return new DruidDataSource();
    }

    @Bean( name = "readDataSource" )
    @ConfigurationProperties(prefix = "tdmember.slave.jdbc")
    public DataSource readDataSource() {
     logger.info("==================>init readDataSource");
      return new DruidDataSource();
    }

    @Bean(name = "dynamicDataSource")
    public DataSource dataSource(@Qualifier("writeDataSource") DataSource writeDataSource,  @Qualifier("readDataSource") DataSource readDataSource) {
     logger.info("------------------------------------------------------ All");

     DynamicDataSource dataSource = new DynamicDataSource();
     Map<Object, Object> ts = new HashMap<Object, Object>();
     ts.put("read", readDataSource);
     ts.put("write", writeDataSource);
     dataSource.setTargetDataSources(ts);
     dataSource.setDefaultTargetDataSource(writeDataSource);
     return dataSource;
    }

    @Bean(name = "dataSourceTransactionManager")
    @ConditionalOnMissingBean
    public DataSourceTransactionManager transactionManager(@Qualifier("writeDataSource") DataSource writeDataSource, @Qualifier("readDataSource") DataSource readDataSource) {

     logger.info("init DataSourceTransactionManager");
     return new DataSourceTransactionManager(dataSource(writeDataSource, readDataSource));
    }

    @Bean(name = "sqlSessionFactory")
    @ConditionalOnMissingBean
    public SqlSessionFactory sqlSessionFactory( @Qualifier("dynamicDataSource")DataSource dataSource) throws Exception {

     logger.info("*****************  init SqlSessionFactory");
     final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
     sessionFactory.setDataSource(dataSource);
     sessionFactory.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));
     sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));
     
     Properties properties = new Properties();
     properties.put("dialect", "mysql");
     sessionFactory.setConfigurationProperties(properties);
     return sessionFactory.getObject();
    }
}
