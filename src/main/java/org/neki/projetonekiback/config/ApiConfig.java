package org.neki.projetonekiback.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApiConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
