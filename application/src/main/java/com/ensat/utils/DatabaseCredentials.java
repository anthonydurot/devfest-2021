package com.ensat.utils;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.sqladmin.SQLAdminScopes;

@Configuration
public class DatabaseCredentials {
    public AccessToken getAccessToken() throws Exception {
        GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
        AccessToken accessToken = credentials.getAccessToken();
        System.out.println(accessToken);
        return accessToken;
    }
}
