package ru.itis.inform.store;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.itis.inform.store.services.StoreServiceImpl;

@Aspect
@Component
public class LoggingAspect {
    private Logger log = LoggerFactory.getLogger(StoreServiceImpl.class);

    @Before("execution(* ru.itis.inform.store.services.StoreServiceImpl.buy(..))")
    public void logMethodBuyExecution(JoinPoint jp) {
        log.info("Customer's buying product '" + jp.getArgs()[0] + "'");
    }
    @Before("execution(* ru.itis.inform.store.services.StoreServiceImpl.isExist(..))")
    public void logMethodIsExistExecution(JoinPoint jp) {
        log.info("Customer checks whether product '" + jp.getArgs()[0] + "' exists");
    }
}
