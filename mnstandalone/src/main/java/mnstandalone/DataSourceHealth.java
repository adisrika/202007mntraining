package mnstandalone;

import io.micronaut.context.annotation.Requires;

import javax.inject.Singleton;
import javax.sql.DataSource;

@Singleton
@Requires(beans = DataSource.class)
public class DataSourceHealth {

}
