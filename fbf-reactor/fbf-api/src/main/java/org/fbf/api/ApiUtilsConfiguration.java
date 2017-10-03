/**
 * 
 */
package org.fbf.api;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author amushate 03 Oct,2017
 */
@Configuration
public class ApiUtilsConfiguration {
	
	@Bean
	public DozerBeanMapper dozerBeanMapper(){
		return new DozerBeanMapper();
	}
}
