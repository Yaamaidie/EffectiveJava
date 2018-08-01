package code.no63;

import java.util.ArrayList;
import java.util.List;

public class StringConcate {
    private List<String> items;

    public StringConcate(int num) {
        this.items = new ArrayList<>(num);
    }

    public void add(String value) {
        items.add(value);
    }

    public int numItems() {
        return items.size();
    }

    public String lineForItem(int index) {
        return items.get(index);
    }

    // Inappropriate use of string concatenation - Performs poorly!
    public long statement() {
        long t1 = System.nanoTime();
        String result = "";
        for (int i = 0; i < numItems(); i++)
            result += lineForItem(i); // String concatenation
        return System.nanoTime() - t1;
    }

    public long statementUsingStringBuilder() {
        long t1 = System.nanoTime();
        StringBuilder b = new StringBuilder(numItems() * 80);
        for (int i = 0; i < numItems(); i++)
            b.append(lineForItem(i));
        return System.nanoTime() - t1;
    }

    public static void main(String[] args) {
        int numItmes = 100;
        StringConcate s = new StringConcate(numItmes);
        for (int i = 0; i < numItmes; i++) {
            s.add("123456789,123456789,123456789,123456789,123456789,123456789,123456789,123456789,");
        }
        long sum = 0;
        for (int i=0 ; i < 5; i++) {
            long t1 = s.statement();
            long t2 = s.statementUsingStringBuilder();
            System.out.println(t1 + "/" + t2 + "=" + t1 / t2);
            sum += t1 / t2;
        }
        System.out.println(sum / 5);
    }
}
