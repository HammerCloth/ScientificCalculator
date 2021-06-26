package com.syx.proxy;

/**
 * @author:syx
 * @date:2021/6/26 11:33
 * @version:v1.0
 */
public class MathImpl implements MathI{
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int sub(int a, int b) {
        return a-b;
    }

    @Override
    public int mul(int a, int b) {
        return a*b;
    }

    @Override
    public int div(int a, int b) {
        return a/b;
    }
}
