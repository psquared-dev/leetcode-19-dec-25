package designpatterns;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Retention(RetentionPolicy.RUNTIME)
@interface MyTransactional{

}

interface PaymentService{
    void pay();
}

class PaymentServiceImpl implements PaymentService{

    @Override
    @MyTransactional
    public void pay() {
        System.out.println(">> Business Logic: Sending money to Merchant...");
    }
}

class TransactionHandler implements InvocationHandler{
    private final Object target;

    public TransactionHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method realMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());

        if(realMethod.isAnnotationPresent(MyTransactional.class)){
            // --- AROUND ADVICE START ---
            System.out.println("[Tx] BEGIN Transaction (Connect to DB)");

            try {
                // 2. Call the Real Method
                Object result = method.invoke(target, args);

                // 3. Success? Commit!
                System.out.println("[Tx] COMMIT Transaction");
                return result;

            } catch (Exception e) {
                // 4. Error? Rollback!
                System.out.println("[Tx] ROLLBACK (Something went wrong)");
                throw e;
            }
            // --- AROUND ADVICE END ---
        } else {
            // If no annotation, just run the method normally
            return method.invoke(target, args);
        }
    }
}



class ProxyFactory {
    public static <T> T createProxy(T target, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(
                interfaceType.getClassLoader(),
                new Class<?>[] { interfaceType },
                new TransactionHandler(target) // Use our handler
        );
    }
}

public class ProxyPattern {
    public static void main(String[] args) {
        PaymentServiceImpl realService = new PaymentServiceImpl();
        PaymentService proxyService = ProxyFactory.createProxy(realService, PaymentService.class);
        System.out.println("--- Client calling pay() ---");
        proxyService.pay();
    }
}
