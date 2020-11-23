package cn.xqc.andLookIntiTheCollection;

public class Test {
    public static void main(String[] args) {
//        BasicImplementation implementation = new BasicImplementation();
//        Node generate = Node.generate(1);
//        Node generate1 = Node.generate(2);
//        Node generate2 = Node.generate(3);
//        Node generate3 = Node.generate(4);
//        Node generate4 = Node.generate(5);
//        implementation.add(generate);
//        implementation.add(generate1);
//        implementation.add(generate2);
//        implementation.add(generate3);
//        implementation.add(generate4);
//        implementation.print();
//
//        System.out.println("________________");
//        implementation.mergeSet(generate,generate1);
//        implementation.mergeSet(generate2,generate1);
//        implementation.mergeSet(generate3,generate1);
//        implementation.mergeSet(generate4,generate1);
//        implementation.print();
        Person[] people = new Person[10];
        for (int i = 0; i < people.length; i++) {
            int id = (int) (Math.random() * 1000000) % 10;
            int qid = (int) (Math.random() * 1000000) % 10;
            int gid = (int) (Math.random() * 1000000) % 10;
            people[i] = new Person(id, qid, gid);
            System.out.println(people[i]);
        }
        Question q = new Question();
        int process = q.process(people);
        System.out.println(process);
    }
}
