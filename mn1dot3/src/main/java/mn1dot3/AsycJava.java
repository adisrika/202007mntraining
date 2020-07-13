package mn1dot3;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class AsycJava {
    public static void main(String[] args) {
        System.out.println("Before " + Thread.currentThread());
        //doSomething();
        Single<String> value = Single.fromCallable(AsycJava::doSomething);
        System.out.println("After " + Thread.currentThread());
        System.out.println(value.subscribeOn(Schedulers.io()).blockingGet());
    }

    static String doSomething() {
        sleep();
        System.out.println("doSomething called " + Thread.currentThread());
        return "Hello";
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
