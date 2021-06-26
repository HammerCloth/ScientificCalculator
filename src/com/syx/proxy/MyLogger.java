package com.syx.proxy;

/**
 * @author:syx
 * @date:2021/6/26 19:27
 * @version:v1.0
 */
public class MyLogger {
    public static void before(String methodName, String args) {
        System.out.println("method:" + methodName + "arguments:" + args);
    }

    public static void after(String methodName, String result) {
        System.out.println("method:" + methodName + "result:" + result);
    }

    public static void throwing(){
        System.out.println("出现异常");
    }
}
