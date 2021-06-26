package com.syx.proxy;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * 动态代理
 * @author:syx
 * @date:2021/6/26 11:43
 * @version:v1.0
 */
public class ProxyUtil {

    private MathI math;

    public Object getProxy(){
        ClassLoader loader = this.getClass().getClassLoader();
        Class[] Interfaces = math.getClass().getInterfaces();
        return Proxy.newProxyInstance(loader, Interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                return method.invoke(math,objects);
            }
        });
    }

}
