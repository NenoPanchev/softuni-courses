package spring.softunimusicdb.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring.softunimusicdb.interceptor.RequestProcessingTimeInterceptor;

@Configuration
public class ApplicationConfig {

    @Bean
    public PasswordEncoder create() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Bean
    public RequestProcessingTimeInterceptor requestProcessingTimeInterceptor() {
        return new RequestProcessingTimeInterceptor();
    }
}
