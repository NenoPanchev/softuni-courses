package spring.softunimusicdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SoftuniMusicDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoftuniMusicDbApplication.class, args);
    }

}
