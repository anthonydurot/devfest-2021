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
            System.out.println("URL récupérée");
            dataSourceBuilder.username(secretManager.getSecret("dark-gateway-330714", "database-username", "latest"));
            System.out.println("Username récupéré");
            dataSourceBuilder.password(secretManager.getSecret("dark-gateway-330714", "database-password", "latest"));
            System.out.println("Password récupéré");
            return dataSourceBuilder.build();
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }
}

