package spring.fundamentals.springbootex.services;

import spring.fundamentals.springbootex.models.entities.Town;

public interface TownService {
    void seedTown(String townName);
    Town getByName(String name);
}
