package gl;

import java.lang.reflect.Proxy;

public class App {
    public static void main(String[] args) {
        TextServiceImpl ts = new TextServiceImpl();
        TextService tsProxy = (TextService) Proxy.newProxyInstance(ts.getClass().getClassLoader(),
                ts.getClass().getInterfaces(),
                new TextServiceInvocationHandler(ts));

        System.out.println(tsProxy.variable("server.port=${port}"));
    }
}
