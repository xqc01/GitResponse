package cn.xqc.avarice;

import java.util.ArrayList;

/**
 * 放灯问题：
 * 给一个由‘X’‘.’组成的字符串，‘X'表示墙，不需要照亮也不能放灯； ‘.'表示一户人家，可以放灯，也需要照亮
 * 一盏灯可以照亮前中后三个位置，要求放置最少的等，照亮所有的‘.’
 */
public class SetUpLights {
    /**
     * 使用暴力的方式，列出所有放灯的方式，返回放灯的下标位置
     *
     * @param string
     * @return
     */
    public ArrayList setUpLights(String string) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        process(string, arrayList, 0, lists);

        int listSize = Integer.MAX_VALUE;
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).size() < listSize) {
                arrayList1 = lists.get(i);
                listSize = arrayList1.size();
            }
        }
        return arrayList1;
    }

    public void process(String string, ArrayList<Integer> arrayList, int index, ArrayList<ArrayList<Integer>> lists) {
        if (index == string.length() - 1) {
            if (isLightUp(string, arrayList))
                lists.add(arrayList);
            return;
        }
        char[] chars = string.toCharArray();
        if (chars[index] == 'X') {
            process(string, arrayList, index + 1, lists);
        } else {
            process(string, arrayList, index + 1, lists);

            Object clone = arrayList.clone();
            ArrayList<Integer> list = (ArrayList<Integer>) clone;
            list.add(index);
            process(string, list, index + 1, lists);
        }
    }

    public boolean isLightUp(String string, ArrayList<Integer> arrayList) {
        boolean is = true;
        char[] chars = string.toCharArray();
        for (int i = 0; i < string.length(); i++) {
            if (chars[i] == 'X')
                continue;
            if (arrayList.contains(i - 1) || arrayList.contains(i) || arrayList.contains(i + 1))
                continue;
            else is = false;
        }
        return is;
    }

    public ArrayList setUpLights2(String string) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'X')
                continue;
            if (chars[i + 1] == '.') {
                arrayList.add(i + 1);
                i = i + 2;
            }
        }
        return arrayList;
    }
}
