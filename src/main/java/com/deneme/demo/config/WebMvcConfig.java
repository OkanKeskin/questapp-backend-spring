//CORS hatası çözümü

package com.deneme.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // CORS ayarlarını burada yapılandırabilirsiniz
        registry.addMapping("/**");
    }

    // Diğer WebMvcConfigurer metotlarını da burada override ederek Spring MVC yapılandırmasını özelleştirebilirsiniz
    // Örneğin, interceptor'ları eklemek için addInterceptors metodu kullanılabilir.
}