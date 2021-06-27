package com.syx.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author:syx
 * @date:2021/6/26 20:07
 * @version:v1.0
 */
@Component
@Aspect
public class MyloggerAspect {
    /**
     * 将方法指定为前置通知
     * 必须设置vlaue，切入点表达式
     */
    //@Before(value = "execution(public int com.syx.aop.MathI.add(int,int))")
    @Before(value = "execution(* com.syx.aop.MathImpl.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();//获取方法参数
        String name = joinPoint.getSignature().getName();//获取方法名
        System.out.println("method:"+name+"arguments:"+ Arrays.toString(args));

    }

    /**
     * 后置通知，作用在方法中finally语句快，不管是否有异常都会执行
     *
     */
    @After(value = "execution(* com.syx.aop.MathImpl.*(..))")
    public void afterMethod(){
        System.out.println("后置通知");
    }

    /**
     * 返回通知，作用在方法执行之后，可以通过设置方法返回值的变量名，也需要在方法的形参中设置和变量名相同的参数
     * @param joinPoint
     * @param result 接收方法的返回指
     */
    @AfterReturning(value = "execution(* com.syx.aop.MathImpl.*(..))",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        String name = joinPoint.getSignature().getName();
        System.out.println("method:"+name+",result:"+result);
    }


    /**
     * 异常通知，当方法抛出异常时作用，通过throw来设置异常信息
     * @param ex
     */
    @AfterThrowing(value = "execution(* com.syx.aop.MathImpl.*(..))",throwing = "ex")
    public void afterThrowing(Exception ex){
        System.out.println("异常了");
        ex.printStackTrace();
    }

    @Around(value = "execution(* com.syx.aop.MathImpl.*(..))")
    public Object aroundM(ProceedingJoinPoint joinPoint){
        try {
            //前置通知
            System.out.println("前置通知");
            Object proceed = joinPoint.proceed();//执行方法
            System.out.println("返回通知");
            //返回通知
            return proceed;
        } catch (Throwable throwable) {
            //异常通知
            System.out.println("异常通知");
            throwable.printStackTrace();
        }finally {
            System.out.println("后置通知");
            //后置通知
        }
        return -1;
    }
}
