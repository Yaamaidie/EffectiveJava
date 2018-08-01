package code.no65;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//测试反射调用相比正常调用的性能损失
public class ReflectionPerformance {
    public static int m() {
        return 12;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        long t1 = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            m();
        }
        long t2 = System.nanoTime() - t1;

        long t3 = System.nanoTime();
        Class c = ReflectionPerformance.class;
        Method m = c.getMethod("m");
        for (int i = 0; i < 100; i++) {
            m.invoke(null);
        }
        long t4 = System.nanoTime() - t3;

        System.out.println(t4 + "/" + t2 + "=" + (t4 / t2));
    }
}
