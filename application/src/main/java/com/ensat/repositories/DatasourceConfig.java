package com.ensat.repositories;

import com.ensat.utils.SecretManager;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfig {
    @Autowired
    SecretManager secretManager;

    @Bean
    public DataSource getDataSource() throws Exception{
        try {
            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.url(secretManager.getSecret("dark-gateway-330714", "database-url", "latest"));
            dataSourceBuilder.username(secretManager.getSecret("dark-gateway-330714", "database-username", "latest"));
            dataSourceBuilder.password(secretManager.getSecret("dark-gateway-330714", "database-password", "latest"));
            return dataSourceBuilder.build();
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }
}

