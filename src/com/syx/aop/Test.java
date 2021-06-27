package com.syx.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author:syx
 * @date:2021/6/26 20:15
 * @version:v1.0
 */
public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AOP.xml");
        MathI mathI = (MathI) context.getBean("mathImpl");
        int add = mathI.div(1, 1);
        System.out.println(add);
    }
}
