package mnday4;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;

import javax.inject.Singleton;

@Singleton
public class ExecuteAroundInterceptor implements MethodInterceptor<Object, Object> {
    @Override
    public Object intercept(MethodInvocationContext<Object, Object> context) {
        System.out.println("Before calling method");
        Object result = context.proceed();
        System.out.println("After calling method");
        return result;
    }
}
