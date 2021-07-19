package course.springdata.jsonprocessingex2.services;

import course.springdata.jsonprocessingex2.models.dtos.PartSeedDto;
import course.springdata.jsonprocessingex2.models.entities.Part;

import java.util.Set;

public interface PartService {
    void seedParts(PartSeedDto[] dtos);
    Set<Part> getSetOfThreeToFiveRandomParts();
}
