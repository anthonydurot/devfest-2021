package com.ensat.repositories;

import com.ensat.utils.DatabaseCredentials;

import javax.persistence.Access;
import javax.sql.DataSource;

import com.google.auth.oauth2.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfig {
    @Autowired
    DatabaseCredentials databaseCredentials;

    @Bean
    public DataSource getDataSource() throws Exception{
        try {
            AccessToken accessToken = databaseCredentials.getAccessToken();
            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.url("jdbc:mysql:///devfest_database_iam");
            dataSourceBuilder.username("evfest@dark-gateway-330714.iam.gserviceaccount.com");
            dataSourceBuilder.password(accessToken.toString());
            return dataSourceBuilder.build();
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }
}

