package cn.xqc.graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 一个人有三个字段，对应三个账户，两个人之间只要有一个账户相同，那么就认为是同一个人
 */
public class SameAccount {
    //错的
    public int same2(Person[] people) {
        int sum = 0;
        HashSet<String> setA = new HashSet<>();
        HashSet<String> setB = new HashSet<>();
        HashSet<String> setC = new HashSet<>();
        for (Person person : people) {
            if (!setA.contains(person.a) && !setB.contains(person.b) && !setC.contains(person.c)) {
                sum++;
            }
            setA.add(person.a);
            setB.add(person.b);
            setC.add(person.c);
        }
        return sum;
    }

    public int same(Person[] people) {
        HashMap<String, Person> mapA = new HashMap<>();
        HashMap<String, Person> mapB = new HashMap<>();
        HashMap<String, Person> mapC = new HashMap<>();
        BingChaJi<Person> bingChaJi = new BingChaJi<>();
        for (Person person : people) {
            bingChaJi.add(person);
        }
        for (Person person : people) {
            if (mapA.containsKey(person.a)) {
                bingChaJi.union(mapA.get(person.a), person);
            } else {
                mapA.put(person.a, person);
            }
            if (mapB.containsKey(person.b)) {
                bingChaJi.union(mapB.get(person.b), person);
            } else {
                mapB.put(person.b, person);
            }
            if (mapC.containsKey(person.c)) {
                bingChaJi.union(mapC.get(person.c), person);
            } else {
                mapC.put(person.c, person);
            }
        }
        return bingChaJi.sizeMap.size();
    }
}

class Person {
    public String a;
    public String b;
    public String c;

    public Person() {
    }

    public Person(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Person{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                '}';
    }

    public static Person[] generate(int n) {
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            int a = (int) (Math.random() * 10000) % 10;
            int b = (int) (Math.random() * 10000) % 10;
            int c = (int) (Math.random() * 10000) % 10;
            people[i] = new Person(String.valueOf(a), String.valueOf(b), String.valueOf(c));
        }
        return people;
    }
}
