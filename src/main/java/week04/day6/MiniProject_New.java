package week04.day6;

/**
 * [종합 미니 프로젝트 - 신규] Week 04 Day 6
 * 「 스마트 홈 IoT 장치 제어 및 관리 시스템 」
 * 
 * 가이드(MiniProjectGuide_New.java)의 요구사항에 따라 
 * 추상 클래스, 인터페이스, 다형성, 내부 클래스, 열거형, 제네릭을 모두 활용해 IoT 시뮬레이터를 완성하세요.
 * 
 * [주의] 동일 패키지 내 클래스명 중복 에러를 방지하기 위해 
 * 아래의 뼈대 클래스/인터페이스/열거형들을 직접 완성하거나 파일 하단에 직접 구현해 주세요.
 */
public class MiniProject_New {
    public static void main(String[] args) {
        // TODO: 1. SmartDevice들을 관리할 제네릭 DeviceManager 객체 생성
        
        // TODO: 2. SmartLight, SmartTV 인스턴스 등록
        
        // TODO: 3. 익명 클래스를 사용한 즉석 SmartDevice 생성 및 등록
        
        // TODO: 4. 전체 제어(controlAll) 실행
    }
}

// TODO: 아래 선언부들의 주석을 해제하고 구현하거나 본인만의 구현을 작성하세요.
/*
enum DeviceType {
    // LIGHT, TV, SENSOR
}

interface Connectable {
    // connectWifi() 추상 메서드와 showSignalStrength() default 메서드 구현
}

abstract class SmartDevice {
    // 필드: name, isOn, type
    // 생성자 및 Getter
    // powerOn(), powerOff() 일반 메서드
    // 추상 메서드: work()
    // 정적 내부 클래스: LogFormatter (로그 포맷용)
}

class SmartLight extends SmartDevice {
    // SmartDevice 상속 및 work() 구현
}

class SmartTV extends SmartDevice implements Connectable {
    // SmartDevice 상속, Connectable 구현, work() 및 connectWifi() 구현
}

class DeviceManager<T extends SmartDevice> {
    // 기기 배열, addDevice 메서드, controlAll 메서드 구현
}
*/
