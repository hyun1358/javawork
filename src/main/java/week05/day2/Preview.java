package week05.day2;

/**
 * [예습 파일] Week 05 Day 2 — 생성자(Constructor) 기초
 * <p>
 * ▶ 이 파일을 먼저 실행해보세요!
 * 객체를 만들자마자 값을 채워넣는 편리한 방법인 '생성자'를 배워봅시다.
 */
public class Preview {
    public static void main(String[] args) {
        // 1. 생성자가 없으면 객체 생성 후 일일이 값을 넣어줘야 했습니다.
        User oldUser = new User();
        oldUser.name = "홍길동";
        oldUser.age = 20;

        // 2. 생성자를 사용하면 객체 생성과 동시에 초기화가 가능합니다.
        // new 클래스명(값1, 값2...);
        User newUser = new User("이순신", 45);

        System.out.println("구식 방법 이름: " + oldUser.name);
        System.out.println("생성자 방법 이름: " + newUser.name);

        System.out.println("--- 오늘 배울 내용 미리보기 끝 ---");
    }
}

class User {
    String name;
    int age;

    // [기본 생성자]
    User() {
    }

    // [매개변수가 있는 생성자]
    User(String n, int a) {
        name = n;
        age = a;
    }
}
