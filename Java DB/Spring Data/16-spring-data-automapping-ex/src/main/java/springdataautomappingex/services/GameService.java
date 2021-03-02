package springdataautomappingex.services;

import springdataautomappingex.domain.dtos.GameAddDto;
import springdataautomappingex.domain.entities.Game;

public interface GameService {
    void addGame(GameAddDto gameAddDto);
    void editGame(String[] data);

    void deleteGame(long id);

    void printAllGames();
    void printGameByTitle(String title);
    Game getGameByTitle(String title);
}
