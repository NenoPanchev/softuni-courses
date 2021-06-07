package spring.softunimusicdb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import spring.softunimusicdb.interceptor.RequestProcessingTimeInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    private final RequestProcessingTimeInterceptor requestProcessingTimeInterceptor;

    public InterceptorConfig(RequestProcessingTimeInterceptor requestProcessingTimeInterceptor) {
        this.requestProcessingTimeInterceptor = requestProcessingTimeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestProcessingTimeInterceptor);
    }
}
