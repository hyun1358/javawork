package week06.day2;

public class Answer3 {
    public static void main(String[] args) {
        Person p1 = new Person("홍길동", 20);
        Person p2 = new Person("홍길동", 20);
        System.out.println("p1.equals(p2) : " + p1.equals(p2));
    }
}

class Person {
    String name;
    int age;

    Person(String n, int a) {
        name = n;
        age = a;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person p = (Person) obj;
            return this.name.equals(p.name) && this.age == p.age;
        }
        return false;
    }
}
