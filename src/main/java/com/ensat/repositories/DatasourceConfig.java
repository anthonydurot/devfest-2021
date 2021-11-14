package com.ensat.repositories;

import com.ensat.utils.DatabaseCredentials;

import javax.persistence.Access;
import javax.sql.DataSource;

import com.google.auth.oauth2.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatasourceConfig {
    @Autowired
    DatabaseCredentials databaseCredentials;

    @Bean
    public DataSource getDataSource() throws Exception{
        try {
            AccessToken accessToken = databaseCredentials.getAccessToken();
            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            String db_name = "iam";
            String db_instance = "dark-gateway-330714:us-central1:devfest-database-instance-new";
            String db_username = "devfest-sql-user";
            String db_password = accessToken.getTokenValue();
            dataSourceBuilder.url(String.format("jdbc:mysql:///%s?cloudSqlInstance=%s&socketFactory=com.google.cloud.sql.mysql.SocketFactory", db_name, db_instance));
            dataSourceBuilder.username(db_username);
            dataSourceBuilder.password(db_password);
            DataSource dataSource = dataSourceBuilder.build();
            System.out.println(dataSource.toString());
            System.out.println(dataSource.getConnection().toString());
            return dataSource;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }
}

