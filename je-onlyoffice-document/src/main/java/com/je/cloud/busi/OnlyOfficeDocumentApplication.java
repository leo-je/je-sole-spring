package com.je.cloud.busi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

@SpringBootApplication
public class OnlyOfficeDocumentApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlyOfficeDocumentApplication.class, args);
	}


	@Bean
	public CookieSerializer httpSessionIdResolver(){
		DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
		cookieSerializer.setCookieName("token");
		cookieSerializer.setUseHttpOnlyCookie(false);
		cookieSerializer.setUseSecureCookie(true);
		return cookieSerializer;
	}

}
