package mnstandalone;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Singleton
public class PriceCalculator {

    @Inject
    Stream<DiscountCalculator> discountCalculator;

    @Inject
    ExternalBean externalBean;

    public Stream<DiscountCalculator> getDiscountCalculator() {
        return discountCalculator;
    }
}
