package week06.day5;

/**
 * [학습 예제 3] Week 06 Day 5 — 인터페이스(Interface)와 다중 구현
 * 
 * [학습 핵심 이론: 인터페이스를 통한 다형성 극대화]
 * 4. 인터페이스 다형성:
 *    - 인터페이스 또한 부모 타입 참조 변수로 활용할 수 있어, 동일한 인터페이스를 구현한 이종(異種) 클래스 객체들을 하나의 인터페이스 배열로 묶어 일괄 조작할 수 있습니다.
 * 
 * [문제별 학습 목표]
 * - Lab3: Printable 규격을 만족하는 문서와 사진 일괄 출력 (Problem 3 연계)
 */
public class Example3 {
    public static void main(String[] args) {
        Printable[] queue = {
            new Document(),
            new Photo(),
            new Document()
        };
        for (Printable p : queue) {
            p.print(); // 일관된 출력 규격 조작
        }
    }

    // Problem 3: Printable 인터페이스와 구현체
    interface Printable {
        void print();
    }

    static class Document implements Printable {
        @Override
        public void print() {
            System.out.println("[문서 출력] 작성된 보고서 텍스트 문서 데이터를 A4 용지에 잉크로 인쇄합니다.");
        }
    }

    static class Photo implements Printable {
        @Override
        public void print() {
            System.out.println("[사진 출력] 고해상도 풍경 이미지 데이터를 광택 사진 전용지에 세밀하게 인쇄합니다.");
        }
    }
}
