package code.no39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class RunTest3 {
    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;

        try (Scanner in = new Scanner(System.in)) {
            System.out.println("请输入要测试的类的完全限定名：");
            Class<?> testClass = Class.forName(in.nextLine());
            for (Method m : testClass.getDeclaredMethods()) {
                if (m.isAnnotationPresent(ExceptionTest2.class)) {
                    tests++;
                    try {
                        m.invoke(null);
                        System.out.println("Test " + m + " is failed: no exception ");
                    } catch (InvocationTargetException e) {
                        Throwable exc = e.getCause();
                        int oldPassed = passed;
                        Class<? extends Throwable>[] excTypes =
                                m.getAnnotation(ExceptionTest2.class).value();
                        for (Class<? extends Throwable> excType : excTypes) {
                            if (excType.isInstance(exc)) {
                                passed++;
                                break;
                            }
                        }
                        if (passed == oldPassed)
                            System.out.printf("Test %s failed: %s %n", m, exc);
                    } catch (Exception e) {
                        System.out.println("不合法的@Test: " + m);
                    }
                }
            }
            System.out.println("Passed: " + passed + ", failed: " + (tests - passed));
        }

    }
}
