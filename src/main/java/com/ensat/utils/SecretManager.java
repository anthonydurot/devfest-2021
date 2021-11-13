package com.ensat.utils;

import com.google.cloud.secretmanager.v1.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecretManager {
    public String getSecret(String projectId, String secretName, String secretVersion) throws Exception {

        try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {

          SecretVersionName secretVersionName = SecretVersionName.of(projectId, secretName, secretVersion);
          AccessSecretVersionResponse secretVersionResponse = client.accessSecretVersion(secretVersionName);
          return secretVersionResponse.getPayload().getData().toStringUtf8();
        }
    }
}
