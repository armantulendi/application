package com.example.withfront.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/icon-fontawesome").setViewName("icon-fontawesome");
        registry.addViewController("/map-google").setViewName("map-google");
        registry.addViewController("/pages-blank").setViewName("pages-blank");
        registry.addViewController("/pages-error-404").setViewName("pages-error-404");
        registry.addViewController("/pages-profile").setViewName("pages-profile");
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/file/**")
                .addResourceLocations("file://"+"/resOfCommand.txt");
    }
}