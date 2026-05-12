package week05.day3;

/**
 * [예습 파일] Week 05 Day 3 — 접근 제어자와 캡슐화 기초
 * <p>
 * ▶ 이 파일을 먼저 실행해보세요!
 * 필드를 꽁꽁 숨기고(private), 메서드를 통해서만 접근하게 만드는 '캡슐화'를 배워봅시다.
 */
public class Preview {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone();

        // 1. private 필드는 외부에서 직접 수정할 수 없습니다. (에러 발생)
        // myPhone.battery = -50; 

        // 2. setter 메서드를 통해 안전하게 값을 변경합니다.
        myPhone.setBattery(80);
        System.out.println("현재 배터리: " + myPhone.getBattery() + "%");

        // 3. 잘못된 값(예: 음수)을 넣으려 하면 메서드 내부에서 걸러냅니다.
        myPhone.setBattery(-20);
        System.out.println("잘못된 값 입력 시도 후 배터리: " + myPhone.getBattery() + "%");

        System.out.println("--- 오늘 배울 내용 미리보기 끝 ---");
    }
}

class SmartPhone {
    // 필드를 숨깁니다. (private)
    private int battery;

    // 값을 가져오는 메서드 (Getter)
    public int getBattery() {
        return battery;
    }

    // 값을 저장하는 메서드 (Setter)
    public void setBattery(int battery) {
        if (battery < 0 || battery > 100) {
            System.out.println("경고: 올바른 배터리 수치가 아닙니다.");
            return;
        }
        this.battery = battery;
    }
}
