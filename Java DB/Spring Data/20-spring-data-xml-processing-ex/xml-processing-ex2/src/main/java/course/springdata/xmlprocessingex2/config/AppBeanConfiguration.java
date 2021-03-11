package course.springdata.xmlprocessingex2.config;

import course.springdata.xmlprocessingex2.utils.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class AppBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ValidationUtil validationUtil() {
        return new ValidationUtilImpl();
    }

    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public XmlParser xmlParser() {
        return new XmlParserImpl();
    }
}
