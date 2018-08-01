package code.no65;

import java.util.Scanner;
import java.util.Set;

/**
 * 下面地程序创建了一个Set<String>实例，它的类是由一个类名字符串指定的。该程序把其他的参数插入到这个集合中，然后打印该集合。
 * 不管第一个参数是什么，程序打印出剩下的参数，并且重复的参数会被消除掉。这些参数的打印顺序取决于第一个参数指定的类。
 * 如果是“java.util.HashMap”，显然会以随机的顺序打印；如果指定“java.uitl.TreeSet”，则他们就会以字母顺序打印出
 */
public class CreatingInstanceReflectively {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String[] params = {"java.util.HashSet c b a d f g e c h \\r", "java.util.TreeSet c b a d f g e c h \\r"};
        for (String p : params) {
            try (Scanner in = new Scanner(p)) {
                String className = in.next();
                System.out.println("使用" + className + "......");
                Class c = Class.forName(className);
                Set<String> obj = (Set<String>)c.newInstance();

                StringBuilder inputParams = new StringBuilder("{");
                String param;
                while (in.hasNext() && !(param = in.next()).equals("\\r")) {
                    inputParams.append(param).append(", ");
                    obj.add(param);
                }
                inputParams = inputParams.delete(inputParams.length() - 2, inputParams.length());
                inputParams.append("}");

                System.out.println("原始的参数集合为：" + inputParams);
                System.out.println("遍历Set集合为：" + obj);
            }
        }
    }
}
