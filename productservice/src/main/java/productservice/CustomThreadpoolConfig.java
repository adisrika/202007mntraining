package productservice;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.EachProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Map;

//@ConfigurationProperties("custom.threadpool")
@EachProperty("custom.threadpool")
public class CustomThreadpoolConfig {
    @NotBlank
    private String name;
    @Min(1)
    private Integer numberOfThreads;
    private Map<String, String> data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfThreads() {
        return numberOfThreads;
    }

    public void setNumberOfThreads(Integer numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
