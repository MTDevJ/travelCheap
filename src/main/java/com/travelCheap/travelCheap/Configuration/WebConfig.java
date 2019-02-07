package com.travelCheap.travelCheap.Configuration;

import com.travelCheap.travelCheap.Service.SenderManager.MessageSenderImpl;
import com.travelCheap.travelCheap.Service.SenderManager.SenderManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler(
                "/webjars/**",
                "/css/**",
                "/js/**",
                "/distr/**",
                "/font/"
        )
                .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/static/css/",
                        "classpath:/static/js/",
                        "classpath:/static/distr/UItoTop/",
                        "classpath:/static/font-awesome-4.7.0/");

        registry.addResourceHandler(
                "/uploads/**")
                .addResourceLocations("file:"+ uploadPath);
    }

    @Bean
    public MessageSenderImpl transferService() {
        return new MessageSenderImpl();
    }
}
