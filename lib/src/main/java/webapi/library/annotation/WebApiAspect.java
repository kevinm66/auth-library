package webapi.library.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import webapi.library.annotation.WebAPI;
import webapi.library.filter.CustomRequestContextFilter;

@Aspect
@Component
//@Import(CustomRequestContextFilter.class)
public class WebApiAspect {
    @Before(value = " @annotation(webapi.library.annotation.WebAPI)")
    public void intercept (JoinPoint joinPoint) throws Throwable {
        System.out.println("Aspect executed");
      //  return joinPoint.proceed();
    }
}
