package cn.small.pig.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

@Configuration
public class MvcWebConfig  implements WebMvcConfigurer  {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("file:///C:\\Users\\dalaomai\\Desktop\\YueQianPeiXun\\shopping-parents\\shopping-goodsmanage-ms\\src\\main/resources/img/");
	}
	
}
