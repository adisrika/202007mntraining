package mnday4;

import javax.inject.Singleton;

@Singleton
public class MyService {

    @ExecuteAround
    public String doSomething() {
        return "Done";
    }
}
