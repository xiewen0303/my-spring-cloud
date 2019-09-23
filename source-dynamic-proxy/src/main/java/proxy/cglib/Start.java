package proxy.cglib;

public class Start {

    public static void main(String[] args) {
        ServiceProxyFactory serviceProxyFactory = new ServiceProxyFactory();
        serviceProxyFactory.getInstance().add();
    }
}
