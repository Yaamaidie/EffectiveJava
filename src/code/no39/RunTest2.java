package code.no39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class RunTest2 {
    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;

        try (Scanner in = new Scanner(System.in)) {
            System.out.println("请输入要测试的类的完全限定名：");
            Class<?> testClass = Class.forName(in.nextLine());
            for (Method m : testClass.getDeclaredMethods()) {
                if (m.isAnnotationPresent(ExceptionTest.class)) {
                    tests++;
                    try {
                        m.invoke(null);
                        System.out.println("Test " + m + " is failed: no exception ");
                    } catch (InvocationTargetException e) {
                        Throwable exc = e.getCause();
                        Class<? extends Throwable> excType = m.getAnnotation(ExceptionTest.class).value();
                        if (excType.isInstance(exc)) {
                            passed++;
                        } else {
                            System.out.println("Test " + m + " failed: expected: " + excType + ", got " + exc);
                        }
                    } catch (Exception e) {
                        System.out.println("不合法的@Test: " + m);
                    }
                }
            }
            System.out.println("Passed: " + passed + ", failed: " + (tests - passed));
        }

    }
}
