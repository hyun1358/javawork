package week04.day6;

/**
 * [종합 미니 프로젝트 정답 - 신규] Week 04 Day 6
 * 「 스마트 홈 IoT 장치 제어 및 관리 시스템 」
 */
public class MiniProjectAnswer_New {
    public static void main(String[] args) {
        // Day 5: 제네릭 객체 생성 (SmartDevice를 상속받은 모든 장치를 담을 수 있는 매니저)
        DeviceManager<SmartDevice> manager = new DeviceManager<>(5);

        // 장치 등록
        manager.addDevice(new SmartLight("거실 전등"));
        manager.addDevice(new SmartTV("안방 TV"));

        // Day 4: 익명 클래스(Anonymous Class)를 활용한 1회성 스마트 가습기 객체 생성 및 등록
        manager.addDevice(new SmartDevice("스마트 가습기", DeviceType.SENSOR) {
            @Override
            public void work() {
                System.out.println(getName() + "이(가) 실내 습도를 감지하여 가습을 시작합니다.");
            }
        });

        System.out.println("=== 스마트 홈 IoT 장치 일괄 제어 작동 ===");
        // 매니저를 통해 일괄 켜기 및 동작 수행
        manager.controlAll();
    }
}

// Day 5: 열거형 (Enum)
enum DeviceType {
    LIGHT, TV, SENSOR
}

// Day 2: 인터페이스 (Interface)
interface Connectable {
    void connectWifi();
    
    // 디폴트 메서드
    default void showSignalStrength() {
        System.out.println("   [Wi-Fi] 연결 신호 강도: 아주 좋음");
    }
}

// Day 1: 추상 클래스 (Abstract Class)
abstract class SmartDevice {
    private String name;
    private boolean isOn;
    private DeviceType type;

    public SmartDevice(String name, DeviceType type) {
        this.name = name;
        this.type = type;
        this.isOn = false;
    }

    public String getName() {
        return name;
    }

    public boolean isOn() {
        return isOn;
    }

    public DeviceType getType() {
        return type;
    }

    // 전원 ON - 내부 클래스 활용
    public void powerOn() {
        this.isOn = true;
        System.out.println(LogFormatter.format(name, "전원 ON"));
    }

    // 전원 OFF - 내부 클래스 활용
    public void powerOff() {
        this.isOn = false;
        System.out.println(LogFormatter.format(name, "전원 OFF"));
    }

    // 자식 클래스에서 강제 구현할 동작
    public abstract void work();

    // Day 4: 정적 내부 클래스 (Static Inner Class)
    public static class LogFormatter {
        public static String format(String deviceName, String action) {
            return String.format("[LOG] 장치명: %-8s | 동작: %s", deviceName, action);
        }
    }
}

// 자식 클래스 1: SmartLight
class SmartLight extends SmartDevice {
    public SmartLight(String name) {
        super(name, DeviceType.LIGHT);
    }

    @Override
    public void work() {
        System.out.println(getName() + "이(가) LED 조명을 50% 밝기로 켭니다.");
    }
}

// 자식 클래스 2: SmartTV (인터페이스 다중 구현)
class SmartTV extends SmartDevice implements Connectable {
    public SmartTV(String name) {
        super(name, DeviceType.TV);
    }

    @Override
    public void work() {
        System.out.println(getName() + "이(가) 최신 드라마 채널을 스트리밍합니다.");
    }

    @Override
    public void connectWifi() {
        System.out.println(getName() + "이(가) 무선 공유기(5G)에 성공적으로 접속했습니다.");
    }
}

// Day 5: 제네릭 클래스 설계
class DeviceManager<T extends SmartDevice> {
    private T[] devices;
    private int size;

    @SuppressWarnings("unchecked")
    public DeviceManager(int capacity) {
        // 제네릭 배열 생성 우회
        this.devices = (T[]) new SmartDevice[capacity];
        this.size = 0;
    }

    public void addDevice(T device) {
        if (size < devices.length) {
            devices[size++] = device;
            System.out.println(device.getName() + " 장치가 시스템에 등록되었습니다.");
        } else {
            System.out.println("더 이상 장치를 등록할 수 없습니다.");
        }
    }

    public void controlAll() {
        for (int i = 0; i < size; i++) {
            T device = devices[i];
            System.out.println("\n-------------------------------------------");
            
            // 1. 전원 켜기
            device.powerOn();
            
            // 2. Wi-Fi 기기일 경우 다형성과 다운캐스팅 적용
            // Day 3: instanceof 와 다운캐스팅
            if (device instanceof Connectable) {
                Connectable wifiDevice = (Connectable) device;
                wifiDevice.connectWifi();
                wifiDevice.showSignalStrength(); // 디폴트 메서드 호출
            }
            
            // 3. 고유 기능 작동 (다형성 호출)
            device.work();
        }
        System.out.println("-------------------------------------------");
    }
}
