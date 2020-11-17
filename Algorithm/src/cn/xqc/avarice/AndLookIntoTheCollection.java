package cn.xqc.avarice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 并查集：
 * 一个节点，有一个向上指向的指针，这个指针默认指向自己，每个节点的代表节点，就是节点不断向上指，直到指针指向自己
 * 并查集作用：判断样本是否属于同一集合，合并集合
 */
public class AndLookIntoTheCollection {
    //存放所有节点
    HashSet<SampleNode> hashSet = new HashSet<>();
    //存放样本节点及其代表点
    HashMap<SampleNode, SampleNode> hashMap = new HashMap<>();
    //存放代表点所在集合的大小  注意：只存放代表节点所在集合的大小，因为集合内所有点都能找到唯一的代表点
    HashMap<SampleNode, Integer> sizeMap = new HashMap<>();

    public void add(SampleNode node) {
        hashSet.add(node);
        hashMap.put(node, node);
        sizeMap.put(node, 1);
    }

    public boolean isSameSet(SampleNode node1, SampleNode node2) {
        if (!hashMap.containsKey(node1) || !hashMap.containsKey(node2))
            return false;
        if (hashMap.get(node1) == hashMap.get(node2))
            return true;
        else return false;
    }

    public void mergeSet(SampleNode node2, SampleNode node1) {
        if (!hashSet.contains(node1) || !hashSet.contains(node2))
            return;
        SampleNode head1 = hashMap.get(node1);
        SampleNode head2 = hashMap.get(node2);

        int size1 = sizeMap.get(head1);
        int size2 = sizeMap.get(head2);

        if (size1 < size2) {
            SampleNode temp = head1;
            head1 = head2;
            head2 = temp;
        }
        head2.last = head1;
        hashMap.put(head2, head1);
        sizeMap.remove(head2);
        sizeMap.put(head1, size1 + size2);
    }

    public void print(){
        System.out.print("HashSet: ");
        for (SampleNode sampleNode : this.hashSet) {
            System.out.print(sampleNode+" ");
        }
        System.out.println();
        System.out.println();

        System.out.print("HashMap: ");
        Set<Map.Entry<SampleNode, SampleNode>> entries = this.hashMap.entrySet();
        for (Map.Entry<SampleNode, SampleNode> entry : entries) {
            System.out.println(entry+" ");
        }
        System.out.println();

        System.out.print("sizeMap: ");
        Set<Map.Entry<SampleNode, Integer>> entries1 = this.sizeMap.entrySet();
        for (Map.Entry<SampleNode, Integer> sampleNodeIntegerEntry : entries1) {
            System.out.println(sampleNodeIntegerEntry+" ");
        }
        System.out.println();
    }
}

/**
 * 样本节点，有向上的指针
 */
class SampleNode {
    public int value;
    public SampleNode last = this;

    public SampleNode() {
    }

    public SampleNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SampleNode{" +
                "value=" + value +
                '}';
    }
}
