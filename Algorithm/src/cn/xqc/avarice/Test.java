package cn.xqc.avarice;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        AvariceString avariceString = new AvariceString();
        String[] strings = {"a","b","c","d","a"};
        avariceString.minDictionaryOrder(strings);
        System.out.println(Arrays.toString(strings));
    }
}
