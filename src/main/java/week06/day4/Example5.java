package week06.day4;

/**
 * [학습 예제 5] Week 06 Day 4 — 추상 클래스(Abstract Class)와 템플릿 메서드 패턴
 * 
 * [학습 핵심 이론: 추상 클래스를 통한 표준 설계 규격]
 * 4. 템플릿 메서드 패턴 (Template Method Pattern):
 *    - 변하지 않는 전체 실행 프로세스(알고리즘 골격)는 부모 추상 클래스 내에 `final` 일반 메서드로 확정해 두고, 중간에 들어갈 가변 세부 로직만 추상 메서드로 자식에게 위임하는 실무 디자인 패턴입니다.
 * 
 * [문제별 학습 목표]
 * - Lab5: 템플릿 메서드 패턴을 이용한 일관된 요리(Food) 조리 흐름 제어 (Problem 5 연계)
 */
public class Example5 {
    public static void main(String[] args) {
        Food food = new Tteokbokki();
        System.out.println("--- 떡볶이 요리 프로세스 가동 ---");
        food.order(); // 일관된 프로세스대로 실행됨을 검증
    }

    // Problem 5: Food 요리 템플릿 메서드 패턴
    static abstract class Food {
        // 공통 스텝 1
        void clean() {
            System.out.println("1단계: 신선한 재료를 흐르는 물에 깨끗이 세척합니다.");
        }

        // 공통 스텝 2
        void trim() {
            System.out.println("2단계: 용도에 맞게 칼로 재료를 알맞게 손질합니다.");
        }

        // 가변 스텝 3 (추상 메서드로 오버라이딩 유도)
        abstract void cook();

        // 공통 스텝 4
        void plate() {
            System.out.println("4단계: 음식을 완성 접시에 보기 좋게 담아 올립니다.");
        }

        // 템플릿 메서드: 전체 알고리즘 뼈대 (흐름을 바꿀 수 없도록 final 선언)
        public final void order() {
            clean();
            trim();
            cook();
            plate();
        }
    }

    static class Tteokbokki extends Food {
        @Override
        void cook() {
            System.out.println("3단계 [떡볶이 조리]: 밀떡을 매콤달콤한 비법 고추장 양념에 잘 버무려 졸이듯 끓입니다.");
        }
    }
}
