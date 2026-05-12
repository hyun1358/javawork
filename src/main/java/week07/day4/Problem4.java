package week07.day4;

/**
 * [연습 문제 4] 예외 계층 구조
 * 문제: 부모 AppError 예외와 자식 DbError 예외를 만들고 부모 타입으로 잡아보세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO
        try
        {
            throw new DbError("db연결실패",404);
        }
        catch(AppError e)
        {
            System.out.println("에러메시지: "+ e.getMessage());
            System.out.println("에러코드: "+ e.getErrorCode());
        }
    }

    static class AppError extends RuntimeException
    {
        private int errorCode;
        AppError(String message,int errorCode)
        {
            super(message);
            this.errorCode = errorCode;
        }
        public int getErrorCode() {return this.errorCode; }
    }
    static class DbError extends AppError
    {
        DbError(String message,int errorCode)
        {
            super(message,errorCode);
        }
    }
}
