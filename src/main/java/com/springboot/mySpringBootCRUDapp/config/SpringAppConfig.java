package com.springboot.mySpringBootCRUDapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringAppConfig implements WebMvcConfigurer {
	@Override
    public void addCorsMappings(CorsRegistry cors) {

		// Для Контроллера конфигурации отдельны поэтому создаем класс для настроек контроллера
		// и тоже пишем addmapping. 
        cors.addMapping("/eCommerceApi/**").allowedOrigins("http://18.226.170.212");
    }
}
