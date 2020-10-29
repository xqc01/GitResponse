package cn.xqc.data_structure;

import java.util.ArrayList;

/**
 * 前缀树:又称字典树
 * 存储字符串，例如：存储'abc'字符串，首先从root节点出发，查看有没有去向'a'的路径，
 * 如果有，则到'a'节点，再查看是否有'b'节点，
 * 如果没有，则创建新的路径
 */
public class PrefixTree {
    //首节点
    public PrefixTreeNode root = new PrefixTreeNode();

    //添加字符串
    public void insert(String str) {
        if (str == null || str == "")
            return;
        char[] chars = str.toCharArray();
        PrefixTreeNode node = root;
        node.pass++;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (node.nodes[index] == null) {
                node.nodes[index] = new PrefixTreeNode();
            }
            node = node.nodes[index];
            node.pass++;
        }
        node.end++;
    }

    //    遍历前缀树
//    public void print(){
//        ArrayList<String>[] lists = new ArrayList[root.pass];
//    }

    //查找字符串
    public int search(String str) {
        if (str == null || str == "")
            return -1;
        PrefixTreeNode node = root;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (node.nodes[index] == null)
                return 0;
            node = node.nodes[index];
        }
        return node.end;
    }

    //删除字符串
    public void delete(String str){
        if (this.search(str) < 1)
            return;
        char[] chars = str.toCharArray();
        PrefixTreeNode node = root;
        node.pass--;
        for (int i = 0; i < chars.length; i++){
            int index = chars[i] - 'a';
            if (node.nodes[index].pass == 1){
                node.nodes[index] = null;
                return;
            }
            node = node.nodes[index];
            node.pass--;
        }
        node.end--;
    }
}

/**
 * 前缀树的节点
 * pass:字符串经过该节点的次数
 * end:在该节点结束的次数
 * nodes:该节点的下级路径，26个字母
 */
class PrefixTreeNode {
    public int pass = 0;
    public int end = 0;
    public PrefixTreeNode[] nodes = new PrefixTreeNode[26];
}
