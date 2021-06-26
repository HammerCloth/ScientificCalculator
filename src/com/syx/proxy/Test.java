package com.syx.proxy;

/**
 * @author:syx
 * @date:2021/6/26 11:39
 * @version:v1.0
 */
public class Test {
    public static void main(String[] args) {
        ProxyUtil proxyUtil = new ProxyUtil(new MathImpl());
        MathI proxy = (MathI) proxyUtil.getProxy();//就是用proxy包装了一下，只能转化为相应的接口
        int add = proxy.div(1, 1);
        System.out.println(add);


    }
}
