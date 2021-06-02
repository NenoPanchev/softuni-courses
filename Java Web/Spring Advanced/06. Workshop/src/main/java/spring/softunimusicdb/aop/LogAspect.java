package spring.softunimusicdb.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* spring.softunimusicdb.web.AlbumController.details(..))")
    public void detailsPointcut() {

    }

    @After("detailsPointcut()")
    public void afterAdvice() {

    }

}
