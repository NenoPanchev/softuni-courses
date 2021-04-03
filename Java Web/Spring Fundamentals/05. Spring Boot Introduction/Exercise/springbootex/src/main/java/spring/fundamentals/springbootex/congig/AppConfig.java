package spring.fundamentals.springbootex.congig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.fundamentals.springbootex.utils.ValidationUtil;
import spring.fundamentals.springbootex.utils.ValidationUtilImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Configuration
public class AppConfig {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    ValidationUtil validationUtil() {
        return new ValidationUtilImpl();
    }

    @Bean
    BufferedReader reader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
