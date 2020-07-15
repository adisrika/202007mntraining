package mndatajdbc;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.async.AsyncCrudRepository;
import io.micronaut.data.repository.reactive.RxJavaCrudRepository;

@JdbcRepository(dialect = Dialect.H2)
//public interface ProductReposotory2 extends AsyncCrudRepository<Product, Long> {
public interface ProductReposotory2 extends RxJavaCrudRepository<Product, Long> {
}
