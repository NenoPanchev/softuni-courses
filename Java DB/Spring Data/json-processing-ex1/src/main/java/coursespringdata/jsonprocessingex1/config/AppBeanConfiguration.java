package coursespringdata.jsonprocessingex1.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import coursespringdata.jsonprocessingex1.utils.FileIOUtil;
import coursespringdata.jsonprocessingex1.utils.FileIOUtilImpl;
import coursespringdata.jsonprocessingex1.utils.ValidationUtil;
import coursespringdata.jsonprocessingex1.utils.ValidationUtilImpl;
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
    public Gson gson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }
    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public FileIOUtil fileIOUtil() {
        return new FileIOUtilImpl();
    }
}
