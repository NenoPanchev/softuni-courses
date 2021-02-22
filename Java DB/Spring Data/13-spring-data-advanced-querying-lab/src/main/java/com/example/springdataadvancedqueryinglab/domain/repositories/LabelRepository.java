package com.example.springdataadvancedqueryinglab.domain.repositories;

import com.example.springdataadvancedqueryinglab.domain.entities.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {
    Label getLabelById(Long id);
}
