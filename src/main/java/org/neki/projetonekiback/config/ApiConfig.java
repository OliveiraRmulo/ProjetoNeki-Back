package org.neki.projetonekiback.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApiConfig implements WebMvcConfigurer {
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*");
    }	
	
//	protected void configure(HttpSecurity http) throws Exception{
//		http.cors().and().csrf().disable().authorizeRequests().anyRequest().authenticated();
//	}
//	
	@Bean
	public PasswordEncoder passwordEncoder() {
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
