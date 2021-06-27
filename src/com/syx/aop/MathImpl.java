package com.syx.aop;

import com.syx.aop.MathI;
import org.springframework.stereotype.Component;

/**
 * @author:syx
 * @date:2021/6/26 11:33
 * @version:v1.0
 */
@Component
public class MathImpl implements MathI {
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
