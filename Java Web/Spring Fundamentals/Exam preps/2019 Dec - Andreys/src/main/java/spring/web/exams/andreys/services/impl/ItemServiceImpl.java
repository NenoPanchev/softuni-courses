package spring.web.exams.andreys.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.web.exams.andreys.model.entity.Category;
import spring.web.exams.andreys.model.entity.Item;
import spring.web.exams.andreys.model.service.CategoryServiceModel;
import spring.web.exams.andreys.model.service.ItemServiceModel;
import spring.web.exams.andreys.model.view.ItemViewModel;
import spring.web.exams.andreys.repositories.ItemRepository;
import spring.web.exams.andreys.services.CategoryService;
import spring.web.exams.andreys.services.ItemService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }


    @Override
    public void addItem(ItemServiceModel map) {
        Item item = this.modelMapper.map(map, Item.class);
        CategoryServiceModel categoryServiceModel = this.categoryService
                .findByCategoryName(map
                        .getCategory().getName());
        Category category = this.modelMapper.map(categoryServiceModel, Category.class);

        item.setCategory(category);
        this.itemRepository.saveAndFlush(item);
    }

    @Override
    public List<ItemViewModel> findAllItems() {
        return this.itemRepository
                .findAll()
                .stream()
                .map(this::getItemViewModel)
                .collect(Collectors.toList());
    }

    @Override
    public ItemViewModel findById(String id) {
        return this.itemRepository.findById(id)
                .map(this::getItemViewModel)
                .orElse(null);
    }

    @Override
    public void delete(String id) {
        this.itemRepository.deleteById(id);
    }

    private ItemViewModel getItemViewModel(Item item) {
        ItemViewModel itemViewModel = this.modelMapper
                .map(item, ItemViewModel.class);

        itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg",
                item.getGender(), item.getCategory().getName()));
        return itemViewModel;
    }


}
