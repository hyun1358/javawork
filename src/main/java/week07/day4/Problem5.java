package week07.day4;

/**
 * [연습 문제 5] 예외 메시지 출력 패턴
 * 문제: e.getMessage(), e.toString(), e.printStackTrace()의 차이점을 실습하세요.
 */
public class Problem5 {
    public static void main(String[] args)
    {
        // TODO
        try
        {
            throw new DbError("db연결실패",404);
        }
        catch(AppError e)
        {
            System.out.println("e.getMessage() "+ e.getMessage());
            System.out.println("==================================");
            System.out.println("e.toString()"+ e.toString());
            System.out.println("==================================");
            e.printStackTrace();

            //e.getMessage()는 RuntimeException에서 오는 메세지를 담고있는 메세지를 가지고온다.
            //e.toString은 어느파일위치에서 무슨 클래스 파일에서 무슨 클래스에 오류메세지가 나오는지 나온다.
            //e.printStackTrace는 어디부분에 오류가 발생하는지 컴파일에러로 나온다.
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
