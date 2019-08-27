package com.baidu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.jdbc.JdbcProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 配置类 替代xml文件
 */
@Configuration
public class jdbcConfig {
    /**
     * 把druid数据库连接池对象的实例放到spring bean 容器
     * @return
     */
    @Bean
    //声明要注入的属性前缀,springboot会自动把相关属性通过set方法注入到datasource中
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource dataSource(){
        //创建数据源
        DruidDataSource dataSource = new DruidDataSource();
        return  dataSource;
    }

}
