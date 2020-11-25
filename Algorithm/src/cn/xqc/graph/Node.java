package cn.xqc.graph;

public class Node <V>{
    public V v;
    public Node<V> last = this;

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
}
