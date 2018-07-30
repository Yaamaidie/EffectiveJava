package test.no55;

import code.no55.MaxValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MaxValueTest {
    public static void main(String[] args) {
        //����emptyʱָ��һ��Ĭ��ֵ
        testDefaultValue();
        //����emptyʱ�׳�һ���׳��쳣
        testThrowException();
    }

    public static void testDefaultValue() {
        List<String> list = new ArrayList<>();
        Optional<String> result = MaxValue.max(list);
        assert !result.isPresent();
        String max = result.orElse("No words");
        System.out.println(max);
    }

    public static void testThrowException() {
        List<String> list = new ArrayList<>();
        Optional<String> result = MaxValue.max(list);
        assert !result.isPresent();
        String max = result.orElseThrow(NullPointerException::new);
        System.out.println(max);
    }

}
