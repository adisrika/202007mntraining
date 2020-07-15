package productservice;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.HttpServerFilter;
import io.micronaut.http.filter.ServerFilterChain;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Filter("/**")
public class MyFilter implements HttpServerFilter {

    private static Logger LOGGER = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public Publisher<MutableHttpResponse<?>> doFilter(HttpRequest<?> request, ServerFilterChain chain) {
        return Flowable.fromCallable(() -> {
            LOGGER.info("Filtering ");
            return true;
        })
                .switchMap(result -> chain.proceed(request))
                .doOnNext(response -> response.getHeaders().add("X-MY-FILTER", "YES"));
    }
}
