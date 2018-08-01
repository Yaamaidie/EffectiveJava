package code.no65;

import java.util.Scanner;
import java.util.Set;

/**
 * ����س��򴴽���һ��Set<String>ʵ��������������һ�������ַ���ָ���ġ��ó���������Ĳ������뵽��������У�Ȼ���ӡ�ü��ϡ�
 * ���ܵ�һ��������ʲô�������ӡ��ʣ�µĲ����������ظ��Ĳ����ᱻ����������Щ�����Ĵ�ӡ˳��ȡ���ڵ�һ������ָ�����ࡣ
 * ����ǡ�java.util.HashMap������Ȼ���������˳���ӡ�����ָ����java.uitl.TreeSet���������Ǿͻ�����ĸ˳���ӡ��
 */
public class CreatingInstanceReflectively {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String[] params = {"java.util.HashSet c b a d f g e c h \\r", "java.util.TreeSet c b a d f g e c h \\r"};
        for (String p : params) {
            try (Scanner in = new Scanner(p)) {
                String className = in.next();
                System.out.println("ʹ��" + className + "......");
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

                System.out.println("ԭʼ�Ĳ�������Ϊ��" + inputParams);
                System.out.println("����Set����Ϊ��" + obj);
            }
        }
    }
}
