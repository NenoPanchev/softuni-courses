package exams.gira.service.impl;

import exams.gira.model.entity.Classification;
import exams.gira.model.entity.ClassificationName;
import exams.gira.model.service.ClassificationServiceModel;
import exams.gira.service.ClassificationService;
import exams.gira.repository.ClassificationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ClassificationServiceImpl implements ClassificationService {
    private final ClassificationRepository classificationRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ClassificationServiceImpl(ClassificationRepository classificationRepository, ModelMapper modelMapper) {
        this.classificationRepository = classificationRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void initClassifications() {
        if (this.classificationRepository.count() == 0) {
            Arrays.stream(ClassificationName.values())
                    .forEach(classificationName -> {
                        this.classificationRepository
                                .save(new Classification(classificationName,
                                        String.format("Description for %s", classificationName.name())));
                    });

        }
    }

    @Override
    public ClassificationServiceModel getClassificationByName(ClassificationName classificationName) {
        return this.classificationRepository.findByClassificationName(classificationName)
                .map(classification -> this.modelMapper.map(classification, ClassificationServiceModel.class))
        .orElse(null);
    }
}
