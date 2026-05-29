package week11.day3;

// 빌더(Builder) 패턴을 사용하여 복잡한 객체를 단계별로 생성하는 예제입니다.
public class Answer1 {
    // 메인 메서드
    public static void main(String[] args) {
        // Builder 객체를 통해 메서드 체이닝 방식으로 옵션(cpu, ram)을 설정하고 최종적으로 build()를 호출하여 Computer 객체를 생성합니다.
        Computer c = new Computer.Builder().cpu("i7").ram("16GB").build();
        // 생성된 객체의 상태를 출력합니다.
        System.out.println(c.cpu + ", " + c.ram);
    }

    // 생성할 대상 클래스
    static class Computer {
        String cpu, ram; // Computer의 부품들

        // private 생성자를 통해 외부에서 직접 객체를 생성하는 것을 막고, Builder를 통해서만 생성되도록 강제합니다.
        private Computer(Builder b) {
            cpu = b.cpu;
            ram = b.ram;
        }

        // Computer 생성을 돕는 정적(static) 내부 빌더 클래스
        public static class Builder {
            String cpu, ram;

            // cpu 값을 설정하고 자신(Builder 객체)을 반환하여 메서드 체이닝을 지원합니다.
            public Builder cpu(String c) {
                cpu = c;
                return this;
            }

            // ram 값을 설정하고 자신을 반환합니다.
            public Builder ram(String r) {
                ram = r;
                return this;
            }

            // 최종적으로 구성된 상태를 바탕으로 Computer 객체를 생성하여 반환합니다.
            public Computer build() {
                return new Computer(this);
            }
        }
    }
}
