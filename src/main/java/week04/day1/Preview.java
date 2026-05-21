package week04.day1;

/**
 * [예습 파일] Week 04 Day 1 — 메서드(Method) 기초
 * 
 * 메서드는 '자주 쓰는 코드 뭉치'에 이름을 붙여놓은 '기능'입니다.
 * 믹서기처럼 재료(매개변수)를 넣으면, 정해진 작업(코드)을 하고 결과물(반환값)을 내놓습니다.
 * 
 * [메서드 구조]
 * 1. 이름 : 이 기능을 뭐라고 부를까?
 * 2. 매개변수(Parameter) : 어떤 재료를 넘겨줄까?
 * 3. 반환타입(Return Type) : 어떤 결과물을 돌려줄까? (없으면 void)
 */
public class Preview {
    public static void main(String[] args) {
        // [사용하기: 호출]
        
        // 1. 단순 호출 (인사하기)
        sayHello();

        // 2. 재료를 넣어서 호출 (이름 전달)
        greet("Gemini");

        // 3. 결과를 받아서 호출 (더하기)
        int result = add(10, 20);
        System.out.println("10 + 20의 결과는? : " + result);
    }

    /**
     * [기능 1] 인삿말을 출력한다. 
     * void: 돌려줄 결과값이 없다는 뜻입니다.
     */
    public static void sayHello() {
        System.out.println("안녕하세요! 반가워요!");
    }

    /**
     * [기능 2] 이름을 받아서 맞춤 인사를 한다.
     * (String name): 문자열 재료 하나가 필요하다는 뜻입니다.
     */
    public static void greet(String name) {
        System.out.println(name + "님, 오늘도 파이팅하세요!");
    }

    /**
     * [기능 3] 두 숫자를 더한 결과를 돌려준다.
     * int: 작업이 끝나면 정수(int)를 결과로 돌려주겠다는 약속입니다.
     */
    public static int add(int a, int b) {
        return a + b; // return: 결과물을 들고 돌아가라!
    }
}
