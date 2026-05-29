package week07.day4;

/**
 * 상속 관계에 있는 예외 클래스들의 다형성(Polymorphism)을 이용한 예외 처리 예제입니다.
 */
public class Answer4 {
    public static void main(String[] args) {
        try {
            // 자식 예외 클래스인 DbError를 발생시킵니다.
            throw new DbError();
        } catch (AppError e) {
            // 부모 타입인 AppError로 자식 예외 객체를 잡을 수 있습니다.
            System.out.println("부모 예외로 잡음");
        }
    }
}

// 애플리케이션의 기본 예외 클래스 (부모 예외)
class AppError extends Exception {
}

// AppError를 상속받는 구체적인 데이터베이스 예외 클래스 (자식 예외)
class DbError extends AppError {
}
