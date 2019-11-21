package com.example.oktasdkexample;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class OktaSdkExampleApplication {

	public static void main(String[] args) {SpringApplication.run(OktaSdkExampleApplication.class, args);
	}

//	@Configuration
//	static class OktaOAuth2WebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http
//					.authorizeRequests().anyRequest().authenticated()
//					.and()
//					.oauth2ResourceServer().jwt();
//
//			// Send a 401 message to the browser (w/o this, you'll see a blank page)
//			Okta.configureResourceServer401ResponseBody(http);
//		}
//	}
}
