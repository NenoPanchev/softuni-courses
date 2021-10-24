package softuni.exam.service;

import softuni.exam.models.entities.Town;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

public interface TownService {

    boolean areImported();

    String readTownsFileContent() throws IOException;
	
	String importTowns() throws FileNotFoundException;

    boolean townExists(String name);
    Optional<Town> findByName(String name);
}
