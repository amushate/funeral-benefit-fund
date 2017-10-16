package org.fbf.api;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

@EnableWebMvc
@Configuration
@ComponentScan("org.fbf")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public MultipartResolver multipartResolver() {
		final CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(50971520L);
		multipartResolver.setMaxInMemorySize(5242880);
		return multipartResolver;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		final BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		return passwordEncoder;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		builder.indentOutput(true).dateFormat(new SimpleDateFormat("dd-MM-yyyy")).modules(new JSR310Module())
				.serializationInclusion(Include.NON_NULL);
		converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
	}
}