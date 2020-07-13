package shoppingservice;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.CircuitBreaker;
import io.micronaut.retry.annotation.Retryable;
import io.reactivex.Flowable;

import java.util.Map;

@Client(id = "productservice")
//@Retryable(attempts = "1")
public interface ProductClient extends ProductOperations{

}
