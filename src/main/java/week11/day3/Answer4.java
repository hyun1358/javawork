package week11.day3;

// 커맨드(Command) 패턴을 사용하여 요청을 객체의 형태로 캡슐화하는 예제입니다.
public class Answer4 {
    // 메인 메서드
    public static void main(String[] args) {
        // 실제 동작을 수행할 Light 객체(수신자)를 생성하고, 이를 조작할 커맨드 객체를 생성합니다.
        Command cmd = new LightOnCommand(new Light());
        // 커맨드 객체의 execute 메서드를 호출하여 조작을 실행합니다.
        cmd.execute();
    }

    // 모든 커맨드 객체가 구현해야 하는 공통 인터페이스
    interface Command {
        void execute(); // 명령을 실행하는 메서드
    }

    // 실제 명령을 받아 작업을 수행하는 수신자(Receiver) 클래스
    static class Light {
        // 불을 켜는 실제 동작 로직
        void on() {
            System.out.println("불이 켜짐");
        }
    }

    // Light 객체의 전원을 켜는 구체적인 명령 클래스
    static class LightOnCommand implements Command {
        Light light; // 명령을 수행할 대상(Receiver) 객체
        
        // 생성자를 통해 조작할 Light 객체를 주입받습니다.
        LightOnCommand(Light l) {
            light = l;
        }
        
        // 명령이 실행될 때, 수신자 객체의 적절한 메서드(on)를 호출하여 실제 동작을 수행합니다.
        @Override
        public void execute() {
            light.on();
        }
    }
}
