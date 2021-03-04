package course.springdata.jsonprocessingex2.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import course.springdata.jsonprocessingex2.utils.FileIOUtil;
import course.springdata.jsonprocessingex2.utils.FileIOUtilImpl;
import course.springdata.jsonprocessingex2.utils.ValidationUtil;
import course.springdata.jsonprocessingex2.utils.ValidationUtilImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    public Gson gson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Bean
    public FileIOUtil fileIOUtil() {
        return new FileIOUtilImpl();
    }
}
