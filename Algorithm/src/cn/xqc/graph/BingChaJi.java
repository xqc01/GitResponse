package cn.xqc.graph;

import java.util.HashMap;
import java.util.Stack;

/**
 * 并查集
 */
public class BingChaJi<V> {
    HashMap<V, Node<V>> hashMap = new HashMap<>();
    HashMap<Node<V>, Node<V>> father = new HashMap<>();
    HashMap<Node<V>, Integer> sizeMap = new HashMap<>();

    public void add(V v) {
        Node<V> value = new Node<>(v);
        hashMap.put(v, value);
        father.put(value, findFather(value));
        sizeMap.put(value, 1);
    }

    public Node<V> findFather(Node<V> node) {
        Node<V> father = node.last;
        Stack<Node<V>> stack = new Stack<>();
        while (father != node) {
            stack.add(node);
            node = father;
            father = father.last;
        }
        while (!stack.isEmpty()) {
            Node<V> pop = stack.pop();
            pop.last = father;
            this.father.put(pop, father);
        }
        return father;
    }

    public boolean isSameSet(V v, V v1) {
        if (!hashMap.containsKey(v) || !hashMap.containsKey(v1))
            return false;
        return findFather(hashMap.get(v)) == findFather(hashMap.get(v1));
    }

    public void union(V v, V v1) {
        if (isSameSet(v, v1))
            return;
        Node<V> vNode = hashMap.get(v);
        Node<V> vNode1 = hashMap.get(v1);
        Node<V> father = findFather(vNode);
        Node<V> father1 = findFather(vNode1);
        Integer size = sizeMap.get(father);
        Integer size1 = sizeMap.get(father1);

        if (size < size1) {
            father.last = father1;
            this.father.put(father, father1);
            sizeMap.remove(father);
            sizeMap.put(father1, size + size1);
        } else {
            father1.last = father;
            this.father.put(father1, father);
            sizeMap.remove(father1);
            sizeMap.put(father, size + size1);
        }
    }
}
