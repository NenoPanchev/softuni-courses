package spring.interceptor.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    @GetMapping("/")
    public String index() {
        LOGGER.info("TEST1");
        LOGGER.info("TEST2");
        LOGGER.info("TEST3");
        LOGGER.info("TEST4");
        LOGGER.info("TEST5");
        return "index";
    }
}
