package web.exams.coffeeshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import web.exams.coffeeshop.model.view.OrderViewModel;
import web.exams.coffeeshop.service.OrderService;
import web.exams.coffeeshop.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    private final OrderService orderService;
    private final UserService userService;

    public HomeController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping()
    public ModelAndView index(ModelAndView modelAndView, HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            modelAndView.setViewName("index");

        } else {
            List<OrderViewModel> orders = orderService.findAllOrderByPriceDesc();
            modelAndView.addObject("orders", orders);
            modelAndView.addObject("totalTime", orders
            .stream()
            .map(orderViewModel -> orderViewModel.getCategory().getNeededTime())
            .reduce(Integer::sum)
            .orElse(0));

            modelAndView.addObject("employees", userService.findAllUsersAndCountOfOrdersOrderByCountDesc());

            modelAndView.setViewName("home");
        }

        return modelAndView;
    }
}
