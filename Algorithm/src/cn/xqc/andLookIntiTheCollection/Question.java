package cn.xqc.andLookIntiTheCollection;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 有一个对象Person，包含三个属性值，两个不同的对象，只要这三个属性值有一个相同，那么就认为时同一个人
 */
public class Question {
    public int process(Person[] people) {
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();
        for (int i = 0; i < people.length; i++) {
            hashSet.add(people[i].id);
            hashSet1.add(people[i].QQid);
            hashSet2.add(people[i].Gid);
        }
        int min = Math.min(hashSet.size(), hashSet1.size());
        min = Math.min(min, hashSet2.size());
        return min;
    }
}

class Person {
    public int id;
    public int QQid;
    public int Gid;

    public Person() {
    }

    public Person(int id, int QQid, int gid) {
        this.id = id;
        this.QQid = QQid;
        Gid = gid;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", QQid=" + QQid +
                ", Gid=" + Gid +
                '}';
    }
}
