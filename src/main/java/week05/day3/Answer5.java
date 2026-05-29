package week05.day3;

/*
 * [정답 5]
 * public: 외부에서 마음대로 값을 바꿀 수 있어 데이터가 오염될 위험이 큼 (예: 나이에 -100 넣기)
 * private + getter/setter: 외부 접근을 차단하고 setter를 통해 올바른 값만 들어오도록 "필터링" 가능.
 * 이를 통해 객체의 무결성을 유지하는 것을 '캡슐화'라고 함.
 */
// [클래스 설명] Answer5는 캡슐화의 목적과 장점을 주석으로 설명하기 위한 예제 클래스입니다.
public class Answer5 {
    // [메서드 설명] 프로그램 실행 시 사용자에게 해설을 안내하는 메인 메서드입니다.
    public static void main(String[] args) {
        // 콘솔에 안내 메시지를 출력합니다.
        System.out.println("주석 해설을 읽어보세요.");
    }
}
