package springdataautomappingex.services;

import springdataautomappingex.domain.entities.Order;

import java.util.Optional;

public interface OrderService {
    void addItem(String title);
    Optional<Order> findById(Long id);

    boolean removeItem(String title);

    void buyItem();
}
