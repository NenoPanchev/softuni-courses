package com.example.football.models.dto.xml;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "stat")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatIdDto {
    @XmlElement
    private Long id;

    public StatIdDto() {
    }

    @Positive
    @NotNull
    public Long getId() {
        return id;
    }

    public StatIdDto setId(Long id) {
        this.id = id;
        return this;
    }
}
