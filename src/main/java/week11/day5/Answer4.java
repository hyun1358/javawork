package week11.day5;

import java.lang.reflect.Field;

// 리플렉션을 응용하여 한 객체의 모든 필드 값을 다른 객체로 얕은 복사하는 예제입니다.
public class Answer4 {
    // 메인 메서드
    public static void main(String[] args) throws Exception {
        // 원본 객체 생성 (값: 10)
        CopyTarget src = new CopyTarget(10);
        // 대상 객체 생성 (값: 0)
        CopyTarget dest = new CopyTarget(0);
        
        // CopyTarget 클래스에 선언된 모든 필드를 순회합니다.
        for (Field f : CopyTarget.class.getDeclaredFields()) {
            // private 등 접근 제한이 걸린 필드라도 접근할 수 있도록 허용합니다.
            f.setAccessible(true);
            // 원본 객체(src)의 필드 값을 읽어서 대상 객체(dest)의 필드 값으로 씁니다(복사).
            f.set(dest, f.get(src)); // 복사
        }
        // 복사된 대상 객체의 필드 값을 출력하여 확인합니다. (10이 출력됨)
        System.out.println(dest.val); // 10
    }
}

// 복사 대상 테스트 클래스
class CopyTarget {
    // 복사할 상태 값을 가지는 필드
    int val;

    // 생성자
    CopyTarget(int v) {
        val = v;
    }
}
