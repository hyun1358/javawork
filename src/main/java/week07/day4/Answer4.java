package week07.day4;

public class Answer4 {
    public static void main(String[] args) {
        try {
            throw new DbError();
        } catch (AppError e) {
            System.out.println("부모 예외로 잡음");
        }
    }
}

class AppError extends Exception {
}

class DbError extends AppError {
}
