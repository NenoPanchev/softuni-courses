package web.exams.coffeeshop.service;

import web.exams.coffeeshop.model.service.OrderServiceModel;
import web.exams.coffeeshop.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrderByPriceDesc();

    void readyOrder(Long id);
}
