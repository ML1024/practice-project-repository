package com.itheima.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class TimeAspect {

    @Around("execution(* com.itheima.service.*.*(..))") //切入点表达式
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //1.记录开始时间
        long begin = System.currentTimeMillis();

        //2.调用原始方法运行
        //ProceedingJoinPoint：AOP提供的API，proceed方法的作用是运行原始方法
        //Object：原始方法运行的返回值
        Object result = joinPoint.proceed();

        //3.记录结束时间，计算方法执行耗时
        //joinPoint中封装了原始方法的相关信息，getSignature拿到原始方法的前面
        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature() + "方法执行耗时：{}ms", end-begin);

        return result;
    }
}
