package spring.hateoas.web;

import spring.hateoas.model.view.OrderViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/orders")
public class OrdersController {

  @PostMapping
  public ResponseEntity<OrderViewModel> enroll(OrderViewModel orderViewModel) {
    //TODO: Create new order
    //TODO: check if the course is enabled!
    return ResponseEntity.ok().build();
  }
}
