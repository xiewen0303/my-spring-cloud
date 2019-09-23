package proxy.jbase;

public class Start {

    public static void main(String[] args) {
        ServiceImpl s = new ServiceImpl();
        ServiceProxyFactory spf = new ServiceProxyFactory(s);
        spf.getInstance().add();
    }
}
