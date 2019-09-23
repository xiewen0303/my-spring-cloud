package proxy.jbase;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ServiceProxyFactory implements InvocationHandler {

    private ServiceImpl si;

    public ServiceProxyFactory(ServiceImpl si) {
        this.si = si;
    }

    /**
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke begin");
        Object invoke = method.invoke(si,args);
        System.out.println("invoke end");
        return invoke;
    }


    public Service getInstance(){
        Service newProxyInstance = (Service) Proxy.newProxyInstance(ServiceImpl.class.getClassLoader(),ServiceImpl.class.getInterfaces(),this);
        return newProxyInstance;
    }



}
