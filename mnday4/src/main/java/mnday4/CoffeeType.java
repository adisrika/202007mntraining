package mnday4;

import io.micronaut.aop.Introduction;
import io.micronaut.context.annotation.Type;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Introduction
@Type(CoffeeIntroductionAdvice.class)
public @interface CoffeeType {
    String value() default "";
}
