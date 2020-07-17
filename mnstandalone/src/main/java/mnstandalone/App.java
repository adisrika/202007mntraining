package mnstandalone;

import io.micronaut.context.ApplicationContext;
import io.micronaut.core.beans.BeanIntrospection;
import io.micronaut.core.beans.BeanProperty;
import io.micronaut.core.beans.BeanWrapper;

import java.beans.Introspector;

public class App {


    public static void main(String[] args) {
        ApplicationContext context = ApplicationContext.run();
        MessageProvider bean = context.getBean(MessageProvider.class);

//        System.out.println(bean.getMessage());
//
//        PriceCalculator priceCalculator = context.getBean(PriceCalculator.class);
//        System.out.println(priceCalculator.getDiscountCalculator());
//
//        System.out.println(context.getBean(ExternalBean.class));

        BeanIntrospection<Product> introspection = BeanIntrospection.getIntrospection(Product.class);
        BeanProperty<Product, String> sku = introspection.getRequiredProperty("sku", String.class);
        Product product = introspection.instantiate();
        sku.set(product, "PRD1");
        System.out.println(product.getSku());

        //BeanWrapper<Product> wrapper = BeanWrapper.getWrapper(product);
        //wrapper.setProperty()

    }
}
