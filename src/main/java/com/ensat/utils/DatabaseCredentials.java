package com.ensat.utils;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.sqladmin.SQLAdminScopes;

import java.io.FileInputStream;
import java.util.Collections;

@Configuration
public class DatabaseCredentials {
    public AccessToken getAccessToken() throws Exception {
        GoogleCredentials credentials = GoogleCredentials.getApplicationDefault().createScoped(Collections.singleton(SQLAdminScopes.SQLSERVICE_ADMIN));
        credentials.refresh();
        credentials.refreshAccessToken();
        AccessToken accessToken = credentials.getAccessToken();
        return accessToken;
    }
}
