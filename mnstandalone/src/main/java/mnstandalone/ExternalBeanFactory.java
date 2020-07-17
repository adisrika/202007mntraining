package mnstandalone;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.inject.InjectionPoint;

import javax.inject.Inject;
import javax.inject.Singleton;

@Factory
public class ExternalBeanFactory {

//    @Bean
//    @Singleton
//    public ExternalBean create() {
//        return new ExternalBean();
//    }

    @Bean
    @Singleton
    public ExternalBean create(InjectionPoint<ExternalBean> injectionPoint) {
        System.out.println("Injection point: " + injectionPoint.getDeclaringBean().getName());
        System.out.println(injectionPoint.getAnnotation(Inject.class).getAnnotationName());
        return new ExternalBean();
    }

}
