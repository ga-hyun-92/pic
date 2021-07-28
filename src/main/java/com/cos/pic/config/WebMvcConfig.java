package com.cos.pic.config;

import com.cos.pic.utils.MyPath;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("나 실행됐어?");

        WebMvcConfigurer.super.addResourceHandlers(registry);
        // 외부경로 이동할때 프로토콜!!!!!!!! ==>file:///
        // /upload/** 로 쓰여진 경로는 "file:///" + MyPath.IMAGEPATH 이렇게 바꿔준다!!
        registry.addResourceHandler("/upload/**").addResourceLocations("file:///" + MyPath.IMAGEPATH)
                .setCachePeriod(60 * 10 * 6).resourceChain(true).addResolver(new PathResourceResolver());

    }
}
