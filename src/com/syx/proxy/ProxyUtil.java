package com.syx.proxy;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 动态代理
 * @author:syx
 * @date:2021/6/26 11:43
 * @version:v1.0
 */
public class ProxyUtil {

    private MathI math;//目标对象（有接口）

    public ProxyUtil(MathI math) {
        this.math = math;
    }

    /**
     * 生成一个代理对象
     * @return
     */
    public Object getProxy(){

        ClassLoader loader = this.getClass().getClassLoader();// 当前类加载器，用于动态生成对象
        Class[] Interfaces = math.getClass().getInterfaces();// 获取目标对象实现的所有接口，用于了解方法
        return Proxy.newProxyInstance(loader, Interfaces, new InvocationHandler() {
            //相同接口产生的方法应该如何执行
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                try{
                    //保证结果一致，调用目标对象的方法
                    MyLogger.before(method.getName(), Arrays.toString(objects));
                    Integer invoke = (Integer)method.invoke(math, objects);//动态代理对像实现
                    MyLogger.after(method.getName(), invoke.toString());
                    return invoke;
                }catch (Exception e){
                    MyLogger.throwing();
                    e.printStackTrace();
                }finally{
                    System.out.println("you always see me");
                }
                return null;
            }
        });
    }

}
