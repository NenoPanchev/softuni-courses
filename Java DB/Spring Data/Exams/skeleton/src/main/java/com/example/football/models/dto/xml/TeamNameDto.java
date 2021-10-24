package com.example.football.models.dto.xml;

import org.hibernate.validator.constraints.Length;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "team")
@XmlAccessorType(XmlAccessType.FIELD)
public class TeamNameDto {
    @XmlElement
    private String name;

    public TeamNameDto() {
    }

    @Length(min = 3)
    public String getName() {
        return name;
    }

    public TeamNameDto setName(String name) {
        this.name = name;
        return this;
    }
}
