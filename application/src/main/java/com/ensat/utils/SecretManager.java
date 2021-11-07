package com.ensat.utils;

import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.secretmanager.v1.*;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.StorageOptions;
import com.google.common.collect.Lists;
import com.google.cloud.storage.Storage;

import java.io.FileInputStream;

public class SecretManager {

    public String getSecret(String projectId, String secretName, String secretVersion) throws Exception {

        try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {

          SecretVersionName secretVersionName = SecretVersionName.of(projectId, secretName, secretVersion);
          AccessSecretVersionResponse secretVersionResponse = client.accessSecretVersion(secretVersionName);
          System.out.printf("Database URL: %s\n", secretVersionResponse.getPayload().getData().toStringUtf8());
          return secretVersionResponse.getPayload().getData().toStringUtf8();
        }
    }
}
