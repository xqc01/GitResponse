package cn.xqc.avarice;

import cn.xqc.code_list.Tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 与字符串有关的贪心算法
 */
public class AvariceString {
    /**
     * 拼接字符串，输出全排列
     *
     * @param strings
     */
    public void concatenatedString(String[] strings) {
        ArrayList<String> results = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        this.concatenatedProcess("", hashSet, results, strings);
    }

    public void concatenatedProcess(String result, HashSet<Integer> hashSet, ArrayList<String> results, String[] strings) {
        if (strings.length - hashSet.size() == 1){
            for (int i = 0;i<strings.length;i++){
                if (!hashSet.contains(i)){
                    result = result + strings[i];
                    results.add(result);
                    System.out.println(result);
                    return;
                }
            }
        }
        for (int i = 0; i < strings.length; i++) {
            if (hashSet.contains(i))
                continue;
//            result = result + strings[i];
            hashSet.add(i);
            /**
             * 此处应当注意：
             * 返回后的恢复现场问题
             * 不仅hashSet要remove，
             * result字符串，如果向前面一样相加赋值，那就要删去之前加的字符串，将字符串还原
             */
            concatenatedProcess(result+strings[i],hashSet,results,strings);
            hashSet.remove(i);
        }
    }

    /**
     * 拼接字符串，使字典序最小
     * 贪心算法，当字符串a与b拼接，小于b与a拼接，则a小于b
     * 将数组排好序后返回，拼接数组
     *
     * @param strings
     */
    public void minDictionaryOrder(String[] strings) {
        for (int i = 1; i < strings.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if ((strings[j + 1] + strings[j]).compareTo(strings[j] + strings[j + 1]) < 0) {
                    String string = strings[j + 1];
                    strings[j + 1] = strings[j];
                    strings[j] = string;
                }
            }
        }
    }
}
