package com.ust.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
@EnableOAuth2Sso  //important annotation to make the login work
public class OAuthSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuthSecurityApplication.class, args);
	}

}
