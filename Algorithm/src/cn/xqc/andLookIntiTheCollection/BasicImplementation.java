package cn.xqc.andLookIntiTheCollection;

import javax.naming.InsufficientResourcesException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * 并查集的基本实现：
 * 将类包装成一个节点，节点有指向上一个的指针，默认指向自己；
 * 并查集中包含储存类和对应节点的map表，还有存储节点和代表点的map表，以及存储节点所在集合大小的map表
 * 方法有：判断两个节点是否在同一个集合，合并两个集合
 */
public class BasicImplementation<V> {
    HashMap<V, Node<V>> map = new HashMap<>();
    HashMap<Node<V>, Node<V>> hashMap = new HashMap<>();
    HashMap<Node<V>, Integer> sizeMap = new HashMap<>();

    /**
     * 关键方法：寻找该节点的代表点，并将沿途所有节点的last指针指向父节点
     *
     * @param node
     * @return
     */
    public Node<V> findFather(Node<V> node) {
        Stack<Node<V>> stack = new Stack<>();
        Node<V> father = node.last;
        while (father != node) {
            stack.add(node);
            node = father;
            father = node.last;
        }
        while (!stack.isEmpty()) {
            Node<V> pop = stack.pop();
            hashMap.remove(pop);
            pop.last = father;
            hashMap.put(pop, father);
        }
        return father;
    }

    public boolean isSameSet(Node<V> node, Node<V> node1) {
        Node<V> father = this.findFather(node);
        Node<V> father1 = this.findFather(node1);
        return father == father1;
    }

    public void mergeSet(Node<V> node, Node<V> node1) {
        Node<V> father = this.findFather(node);
        Node<V> father1 = this.findFather(node1);
        int size = sizeMap.get(father);
        int size1 = sizeMap.get(father1);
        if (size > size1) {
            father1.last = father;
            sizeMap.remove(father1);
            sizeMap.put(father, size + size1);
        } else {
            father.last = father1;
            sizeMap.remove(father);
            sizeMap.put(father1, size + size1);
        }
        findFather(node);
        findFather(node1);
    }

    public void add(Node<V> node) {
        map.put(node.v, node);
        hashMap.put(node, this.findFather(node));
        sizeMap.put(this.findFather(node), 1);
    }

    public void print() {
        Set<Map.Entry<V, Node<V>>> entries = map.entrySet();
        for (Map.Entry<V, Node<V>> entry : entries) {
            System.out.print(entry + " ");
        }
        System.out.println();

        Set<Map.Entry<Node<V>, Node<V>>> entries1 = hashMap.entrySet();
        for (Map.Entry<Node<V>, Node<V>> nodeNodeEntry : entries1) {
            System.out.print(nodeNodeEntry + " ");
        }
        System.out.println();

        Set<Map.Entry<Node<V>, Integer>> entries2 = sizeMap.entrySet();
        for (Map.Entry<Node<V>, Integer> nodeIntegerEntry : entries2) {
            System.out.print(nodeIntegerEntry + " ");
        }
        System.out.println();
    }
}

class Node<V> {
    public Node<V> last = this;
    public V v;

    public Node() {
    }

    public Node(V v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "Node{" +
                "v=" + v +
                '}';
    }

    public static Node generate(int n) {
        Node<Integer> node = new Node<>(0);
        for (int i = 1; i < n; i++) {
            node.last = new Node<Integer>(i);
        }
        return node;
    }
}
