package softuni.exam.service;

import softuni.exam.models.entities.Plane;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

public interface PlaneService {

    boolean areImported();

    String readPlanesFileContent() throws IOException;
	
	String importPlanes() throws JAXBException, FileNotFoundException;

	boolean planeExists(String registerNumber);
	Optional<Plane> findByRegisterNumber(String registerNumber);
}
