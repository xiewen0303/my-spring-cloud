package proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import proxy.jbase.Service;
import proxy.jbase.ServiceImpl;

import java.lang.reflect.Method;

public class ServiceProxyFactory implements MethodInterceptor {

    public Service getInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ServiceImpl.class);
        enhancer.setCallback(this);
        return (Service) enhancer.create();
    }

    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy)   throws Throwable {
        System.out.println("cglib proxy begin .");
        Object invokeSupper = methodProxy.invokeSuper(proxy,args);
        System.out.println("cglib proxy end .");
        return invokeSupper;
    }
}
