package org.fbf.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan("org.fbf")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public RestTemplate template(){
        return new RestTemplate();
    }
    
    /*@Bean(name = "multipartResolver")
	public MultipartResolver getMultipartResolver() {
		final CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(50971520L);
		multipartResolver.setMaxInMemorySize(5242880);
		return multipartResolver;
	}*/


}