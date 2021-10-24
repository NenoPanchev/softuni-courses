package com.example.football.service;

import com.example.football.models.entity.Team;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

public interface TeamService {
    boolean areImported();

    String readTeamsFileContent() throws IOException;

    String importTeams() throws FileNotFoundException;

    Optional<Team> findByName(String name);
}
