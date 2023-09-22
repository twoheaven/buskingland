package com.buskingland.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig implements WebMvcConfigurer {

    @Bean
    public CorsFilter corsFilter() {
        // CORS 구성 정보를 생성하고 설정합니다.
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        
        // 인증 정보 허용 설정 (예: 쿠키)
        config.setAllowCredentials(true);
        
        // 허용할 출처 설정 (예: 로컬 개발 환경 및 예제 도메인)
        config.addAllowedOrigin("http://localhost:3000"); // 로컬 개발 환경
        config.addAllowedOrigin("https://example.com"); // 실제 도메인
        
        // 허용할 HTTP 메서드 설정
        config.addAllowedMethod("POST");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PUT");
        
        // 모든 URL에 대한 CORS 구성을 등록합니다.
        source.registerCorsConfiguration("/**", config);
        
        // CORS 필터를 생성하고 반환합니다.
        return new CorsFilter(source);
    }
}