package com.example.football.models.dto.xml;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "stat")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatSeedDto {
    @XmlElement
    private Float passing;
    @XmlElement
    private Float shooting;
    @XmlElement
    private Float endurance;

    public StatSeedDto() {
    }

    @Positive
    @NotNull
    public Float getPassing() {
        return passing;
    }

    public StatSeedDto setPassing(Float passing) {
        this.passing = passing;
        return this;
    }

    @Positive
    @NotNull
    public Float getShooting() {
        return shooting;
    }

    public StatSeedDto setShooting(Float shooting) {
        this.shooting = shooting;
        return this;
    }

    @Positive
    @NotNull
    public Float getEndurance() {
        return endurance;
    }

    public StatSeedDto setEndurance(Float endurance) {
        this.endurance = endurance;
        return this;
    }
}
