package week06.day2;

public class Answer3 {
    public static void main(String[] args) {
        // 내용(이름, 나이)이 같은 두 개의 독립적인 Person 객체를 생성합니다.
        Person p1 = new Person("홍길동", 20);
        Person p2 = new Person("홍길동", 20);
        
        // 재정의된 equals() 메서드를 통해 메모리 주소가 아닌 실제 데이터 값(내용)이 같은지 비교합니다.
        System.out.println("p1.equals(p2) : " + p1.equals(p2)); // true 출력
    }
}

// [클래스 설명] Object 클래스의 equals() 메서드를 오버라이딩하여 객체의 '값'을 비교하는 방법을 보여줍니다.
class Person {
    String name;
    int age;

    Person(String n, int a) {
        name = n;
        age = a;
    }

    // [메서드 설명] 객체의 메모리 주소 비교가 아닌, 실제 필드 값(이름, 나이)이 동일한지 비교하도록 재정의합니다.
    @Override
    public boolean equals(Object obj) {
        // 전달받은 객체가 Person 타입인지 확인(instanceof)하여 안전하게 형변환(Casting)합니다.
        if (obj instanceof Person) {
            Person p = (Person) obj;
            // 이름 문자열의 내용이 같고, 나이 숫자 값이 같으면 동일한 사람으로 간주하여 true를 반환합니다.
            return this.name.equals(p.name) && this.age == p.age;
        }
        return false; // Person 타입이 아니면 무조건 false를 반환합니다.
    }
}
