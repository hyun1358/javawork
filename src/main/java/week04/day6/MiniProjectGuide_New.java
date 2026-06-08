package week04.day6;

/**
 * [종합 미니 프로젝트 가이드 - 신규] Week 04 Day 6
 * 「 스마트 홈 IoT 장치 제어 및 관리 시스템 」
 * 
 * [목적]
 *   Week 04에서 배운 고급 객체지향 개념(추상 클래스, 인터페이스, 다형성, 내부 클래스, 열거형, 제네릭)을
 *   모두 활용하여 확장성 있는 IoT 장치 제어 시뮬레이터를 작성합니다.
 * 
 * [활용 개념 — Day별 대응]
 *   - Day 1 (추상 클래스):
 *       모든 스마트 기기의 공통 분모인 SmartDevice 추상 클래스 설계. 
 *       공통 전원 제어 기능을 템플릿(정의된 메서드)으로 제공하고, 핵심 동작은 추상 메서드 work()로 자식이 구현하도록 강제.
 *   - Day 2 (인터페이스):
 *       Wi-Fi 연결 기능을 제공하는 Connectable 인터페이스 정의. 
 *       공통 연결 메시지를 제공하는 default 메서드 showSignalStrength() 포함.
 *   - Day 3 (다형성):
 *       SmartDevice 타입의 배열을 순회하며 다형성 호출(work() 실행).
 *       instanceof 및 다운캐스팅을 사용해 Connectable을 구현한 기기에만 Wi-Fi 연결 명령 전달.
 *   - Day 4 (내부 클래스):
 *       SmartDevice 클래스 내부에 장치 상태 변경 로그를 포맷팅하는 정적 내부 클래스(LogFormatter) 정의.
 *       메인 함수에서 임시 스마트 장치(예: AI 스피커)를 익명 클래스(Anonymous Class)로 즉석 정의하여 사용.
 *   - Day 5 (열거형과 제네릭):
 *       장치의 동작 카테고리를 명시하는 DeviceType 열거형(LIGHT, TV, SENSOR) 사용.
 *       스마트 기기들을 안전하게 담아 관리하고 일괄 작동시키는 제네릭 컨테이너 DeviceManager<T extends SmartDevice> 클래스 구현.
 * 
 * [상세 요구사항]
 *   1. DeviceType 열거형 (Enum): LIGHT, TV, SENSOR 구성
 *   2. Connectable 인터페이스:
 *      - 추상 메서드: void connectWifi();
 *      - default 메서드: void showSignalStrength() { System.out.println("Wi-Fi 신호 강도: 좋음"); }
 *   3. SmartDevice 추상 클래스:
 *      - 필드: private String name, private boolean isOn, private DeviceType type
 *      - 생성자: name, type 매개변수로 초기화
 *      - 일반 메서드: 
 *        * void powerOn(): isOn = true로 설정 후 내부 클래스를 통해 로그 출력
 *        * void powerOff(): isOn = false로 설정 후 로그 출력
 *      - 추상 메서드: abstract void work();
 *      - 정적 내부 클래스: static class LogFormatter { static String format(String name, String action); }
 *   4. 자식 클래스 구현:
 *      - SmartLight: SmartDevice 상속, work() 오버라이딩("조명을 밝힙니다.")
 *      - SmartTV: SmartDevice 상속 및 Connectable 구현, work() 오버라이딩("TV 방송을 출력합니다."), connectWifi() 구현("TV가 Wi-Fi에 연결되었습니다.")
 *   5. 제네릭 매니저 클래스:
 *      - class DeviceManager<T extends SmartDevice> 정의
 *      - 필드: T[] devices, int count
 *      - 메서드: 
 *        * void addDevice(T device)
 *        * void controlAll() : 모든 기기 전원을 켜고, work()를 수행시킴. 기기가 Connectable을 구현하고 있다면 connectWifi()와 showSignalStrength() 호출.
 *   6. 메인 프로그램 흐름:
 *      - DeviceManager<SmartDevice> 인스턴스 생성
 *      - SmartLight, SmartTV 객체 등록
 *      - 익명 클래스를 사용해 일회성 장치인 "스마트 가습기"를 생성하여 등록
 *      - manager.controlAll()을 호출해 다형성 제어 결과 확인
 */
public class MiniProjectGuide_New {
}
