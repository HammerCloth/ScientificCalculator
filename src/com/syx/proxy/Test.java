package com.syx.proxy;

/**
 * @author:syx
 * @date:2021/6/26 11:39
 * @version:v1.0
 */
public class Test {
    public static void main(String[] args) {
        MathI mathI = new MathImpl();
        int result = mathI.add(1, 1);
        System.out.println(result);
    }
}
