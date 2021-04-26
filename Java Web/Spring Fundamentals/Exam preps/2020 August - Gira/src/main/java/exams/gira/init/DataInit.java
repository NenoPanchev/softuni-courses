package exams.gira.init;

import exams.gira.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {
    private final ClassificationService classificationService;

    @Autowired
    public DataInit(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.classificationService.initClassifications();
    }
}
