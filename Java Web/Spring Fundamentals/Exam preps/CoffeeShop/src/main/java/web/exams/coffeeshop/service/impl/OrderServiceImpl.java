package web.exams.coffeeshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import web.exams.coffeeshop.model.entity.CategoryNameEnum;
import web.exams.coffeeshop.model.entity.Order;
import web.exams.coffeeshop.model.entity.User;
import web.exams.coffeeshop.model.service.OrderServiceModel;
import web.exams.coffeeshop.model.service.UserServiceModel;
import web.exams.coffeeshop.model.view.OrderViewModel;
import web.exams.coffeeshop.repository.OrderRepository;
import web.exams.coffeeshop.service.CategoryService;
import web.exams.coffeeshop.service.OrderService;
import web.exams.coffeeshop.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, HttpSession httpSession, UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {
        UserServiceModel userServiceModel = (UserServiceModel) httpSession.getAttribute("user");
        User user = userService.findByUsername(userServiceModel.getUsername());
        Order order = modelMapper.map(orderServiceModel, Order.class)
                .setCategory(categoryService.findByCategoryNameEnum(orderServiceModel.getCategory()))
                .setEmployee(modelMapper.map(user, User.class));

        orderRepository.save(order);
    }

    @Override
    public List<OrderViewModel> findAllOrderByPriceDesc() {
        return orderRepository.findAllByOrderByPriceDesc()
                .stream()
                .map(entity -> modelMapper.map(entity, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void readyOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
