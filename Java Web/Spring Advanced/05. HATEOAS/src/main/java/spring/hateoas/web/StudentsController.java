package spring.hateoas.web;

import spring.hateoas.model.view.CourseViewModel;
import spring.hateoas.model.view.OrderViewModel;
import spring.hateoas.model.entity.Student;
import spring.hateoas.model.view.StudentViewModel;
import spring.hateoas.repository.OrderRepository;
import spring.hateoas.repository.StudentRepository;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/students")
public class StudentsController {

  private final StudentRepository studentRepository;
  private final ModelMapper mapper;

  public StudentsController(StudentRepository studentRepository,
      ModelMapper mapper) {
    this.studentRepository = studentRepository;
    this.mapper = mapper;
  }

  @GetMapping("/{id}")
  public ResponseEntity<EntityModel<StudentViewModel>> getStudentById(@PathVariable Long id) {
    StudentViewModel student = studentRepository.
        findById(id).
        map(s -> mapper.map(s, StudentViewModel.class)).
        orElseThrow();

    return ResponseEntity.ok(
        EntityModel.of(student, createStudentLinks(student)));
  }

  private Link[] createStudentLinks(StudentViewModel studentViewModel) {
    List<Link> result = new ArrayList<>();

    Link selfLink = linkTo(methodOn(StudentsController.class).
        getStudentById(studentViewModel.getId())).withSelfRel();
    result.add(selfLink);


    Link ordersLink = linkTo(methodOn(StudentsController.class).
          getOrdersByStudent(studentViewModel.getId())).
          withRel("orders");
    result.add(ordersLink);

    return result.toArray(new Link[0]);
  }

  @GetMapping("/{id}/orders")
  public ResponseEntity<CollectionModel<EntityModel<OrderViewModel>>>
    getOrdersByStudent(@PathVariable Long id) {

    Student studentEntity =
        studentRepository.findById(id).orElseThrow();

    List<EntityModel<OrderViewModel>> orders =  studentEntity.
        getOrders().
        stream().
        map(OrderViewModel::asDTO).
        map(EntityModel::of).
        collect(Collectors.toList());

    return ResponseEntity.ok(CollectionModel.of(orders));
  }

}
