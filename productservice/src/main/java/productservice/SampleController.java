package productservice;

import io.micronaut.http.annotation.*;

@Controller("/sample")
public class SampleController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}