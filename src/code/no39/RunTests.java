package code.no39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class RunTests {
    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;

        try (Scanner in = new Scanner(System.in)) {
            System.out.println("请输入要测试的类的完全限定名：");
            Class<?> testClass = Class.forName(in.nextLine());
            for (Method m : testClass.getDeclaredMethods()) {
                if (m.isAnnotationPresent(Test.class)) {
                    tests++;
                    try {
                        m.invoke(null);
                        passed++;
                    } catch (InvocationTargetException e) {
                        Throwable ex = e.getCause();
                        System.out.println(m + " failed: " + ex);
                    } catch (Exception e) {
                        System.out.println("不合法的@Test: " + m);
                    }
                }
            }
            System.out.println("Passed: " + passed + ", failed: " + (tests - passed));
        }

    }
}
