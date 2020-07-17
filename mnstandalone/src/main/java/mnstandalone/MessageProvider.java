package mnstandalone;

import javax.inject.Singleton;

@Singleton
public class MessageProvider {

    public String getMessage() {
        return "Hello";
    }
}
