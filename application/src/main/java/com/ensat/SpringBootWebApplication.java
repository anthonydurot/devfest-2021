package com.ensat;

import com.ensat.utils.SecretManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebApplication {

    public static void main(String[] args) {
        SecretManager secretManager = new SecretManager();
        try {
            System.out.println(secretManager.getSecret("dark-gateway-330714", "database-url", "latest"));
        } catch (Exception e) {
            System.out.println(e);
        }
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

}
