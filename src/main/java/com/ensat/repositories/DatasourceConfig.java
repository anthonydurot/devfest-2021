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
            String db_name = "devfest_database_iam";
            String db_instance = " devfest-database-instance-new ";
            String db_username = "devfest-sql-user@dark-gateway-330714.iam.gserviceaccount.com";
            String db_password = accessToken.toString();
            dataSourceBuilder.url(String.format("jdbc:mysql:///%s?cloudSqlInstance=%s&socketFactory=com.google.cloud.sql.mysql.SocketFactory&user=%s&password=%s", db_name, db_instance, db_username, db_password));
            return dataSourceBuilder.build();
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }
}

