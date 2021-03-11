package course.springdata.xmlprocessingex2.services;

import course.springdata.xmlprocessingex2.models.dtos.PartSeedDto;
import course.springdata.xmlprocessingex2.models.entities.Part;

import java.util.List;
import java.util.Set;

public interface PartService {
    void seedParts(List<PartSeedDto> dtos);
    Set<Part> getSetOfTenToTwentyRandomParts();
}
