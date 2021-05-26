package spring.errorhandling.global;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController2 {

  private static final Logger LOGGER = LoggerFactory.getLogger(HelloController2.class);

  @GetMapping("/hello2-ex-custom")
  public ModelAndView customException() {
    throw new HelloException("HELLO fro Controller 2!");
  }

  @GetMapping("/global-vs-controller")
  public ModelAndView gvc() {
    throw new HelloException("Controller wins!");
  }

  @ExceptionHandler({HelloException.class})
  public ModelAndView helloExceptionHandle(HelloException he) {
    ModelAndView modelAndView = new ModelAndView("handler");
    modelAndView.addObject("message", he.getMessage());

    LOGGER.error("Exception caught", he);
    return modelAndView;
  }
}
