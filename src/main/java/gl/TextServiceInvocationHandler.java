package gl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TextServiceInvocationHandler implements InvocationHandler {

    private TextServiceImpl textService;
    private static final String PORT_PROPERTY = "port";
    private static final String PORT_REPLACEMENT = "${port}";

    public TextServiceInvocationHandler(TextServiceImpl textService) {
        this.textService = textService;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getName().equals("variable")) {
            if (System.getProperty(PORT_PROPERTY) != null) {
                String argStr = (String) args[0];
                if ((argStr.contains(PORT_REPLACEMENT))) {
                    String portVal = System.getProperty(PORT_PROPERTY);
                    return argStr.replace(PORT_REPLACEMENT, portVal);
                }
            }
        }

        return method.invoke(textService, args);
    }

}
