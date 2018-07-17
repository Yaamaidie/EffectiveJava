package test.no3;

import code.no3.Singleton;

/**
 * Created by HP-PC on 2018/6/20.
 */
public class SingletonTest {
    public static void main(String[] args) {
        Singleton singleton = Singleton.INSTANCE;
        System.out.println(singleton);
    }
}
