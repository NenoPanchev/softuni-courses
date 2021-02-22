package com.example.springdataadvancedqueryinglab.domain.services.impl;

import com.example.springdataadvancedqueryinglab.domain.entities.Label;
import com.example.springdataadvancedqueryinglab.domain.repositories.LabelRepository;
import com.example.springdataadvancedqueryinglab.domain.services.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl implements LabelService {
    private final LabelRepository labelRepository;

    @Autowired
    public LabelServiceImpl(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    @Override
    public Label getLabelById(Long id) {
        return this.labelRepository.getLabelById(id);
    }
}
