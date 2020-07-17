package mnday4;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;

import javax.inject.Singleton;

@Singleton
public class CoffeeIntroductionAdvice implements MethodInterceptor<Object, Coffee> {
    @Override
    public Coffee intercept(MethodInvocationContext<Object, Coffee> context) {
        String value = context.getValue(CoffeeType.class, String.class).get();
        return new Coffee(value);
    }
}
