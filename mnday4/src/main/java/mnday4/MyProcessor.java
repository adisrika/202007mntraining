package mnday4;

import io.micronaut.context.processor.ExecutableMethodProcessor;
import io.micronaut.inject.BeanDefinition;
import io.micronaut.inject.ExecutableMethod;

import javax.inject.Singleton;

@Singleton
public class MyProcessor implements ExecutableMethodProcessor<MyMethod> {

    @Override
    public void process(BeanDefinition<?> beanDefinition, ExecutableMethod<?, ?> method) {
        System.out.println("Bean: " + beanDefinition.getName() + " Method " + method.toString());
        //method.i
    }
}
