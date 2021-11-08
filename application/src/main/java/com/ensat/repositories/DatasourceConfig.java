package com.ensat.repositories;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfig {
    @Value("${dburl}")
    String dburl;
    @Value("${dbusername}")
    String dbusername;
    @Value("${dbpassword}")
    String dbpassword;
    @Bean
    public DataSource getDataSource() throws Exception {

        try {
            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.url(dburl);
            dataSourceBuilder.username(dbusername);
            dataSourceBuilder.password(dbpassword);
            return dataSourceBuilder.build();
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }
}
