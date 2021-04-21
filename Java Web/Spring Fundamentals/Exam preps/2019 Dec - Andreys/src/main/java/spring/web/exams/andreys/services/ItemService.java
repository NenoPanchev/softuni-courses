package spring.web.exams.andreys.services;

import spring.web.exams.andreys.model.service.ItemServiceModel;
import spring.web.exams.andreys.model.view.ItemViewModel;

import java.util.List;

public interface ItemService {
    void addItem(ItemServiceModel map);

    List<ItemViewModel> findAllItems();

    ItemViewModel findById(String id);

    void delete(String id);
}
