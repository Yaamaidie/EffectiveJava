package code.no45;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// Prints all large anagram groups in a dictionary iteratively
public class Anagrams {
    public static void main(String[] args) throws FileNotFoundException {
        String path = ClassLoader.getSystemClassLoader().getResource("code/no45/release_notes.txt").getPath();
        File dictionary = new File(path);
        int minGroupSize = 2;

        Map<String, Set<String>> groups = new HashMap<>();
        try (Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                String word = s.next();
                //����word����Ȼ�����map�в����ڴ���Ȼ����put(��Ȼ��, �µĿ�TreeSet)��Ȼ��word�ӵ����TreeSet�С�
                groups.computeIfAbsent(alphabetize(word), unused -> new TreeSet<>()).add(word);
            }
        }
        for (Set<String> group : groups.values()) {
            if (group.size() >= minGroupSize) {
                System.out.println(group.size() + ": " + group);
            }
        }
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
