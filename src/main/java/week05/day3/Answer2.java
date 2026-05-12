package week05.day3;

public class Answer2 {
    public static void main(String[] args) {
        PersonAnswer p = new PersonAnswer();
        p.setAge(-10);
        System.out.println("나이: " + p.getAge());
    }
}

class PersonAnswer {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("잘못된 입력입니다.");
            return;
        }
        this.age = age;
    }
}
