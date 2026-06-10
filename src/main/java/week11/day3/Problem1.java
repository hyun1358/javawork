package week11.day3;

/**
 * [연습 문제 1] Computer 빌더
 * 문제: CPU, RAM, SSD 용량을 체이닝으로 설정하여 객체를 반환하는 Computer 빌더를 작성하세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // 1. ramGb, ssdGb 메서드 명칭(소문자 b)을 맞추고, int 타입(예: 16, 512)을 대입합니다.
        // 2. 클래스 내부의 빌드 완성 메서드 이름인 .builder()를 호출하여 체이닝을 마무리합니다.
        Computer computer = new Computer.Builder()
                .cpu("Razen5 7800x3d")
                .ramGB(16)
                .ssdGB(512)
                .builder();

        System.out.println("생성된 컴퓨터 - CPU: " + computer.cpu + ", RAM: " + computer.ramGB + "GB, SSD: " + computer.ssdGB + "GB");
    }

    static class Computer
    {
        private String cpu;
        private int ramGB;
        private int ssdGB;

        private Computer(Builder b)
        {
            this.cpu = b.cpu;
            this.ramGB = b.ramGB;
            this.ssdGB = b.ssdGB;
        }

        static class Builder
        {
            private String cpu;
            private int ramGB;
            private int ssdGB;

            public Builder cpu(String cpu) {this.cpu = cpu; return this;}
            public Builder ramGB(int ramGB) {this.ramGB = ramGB; return this;}
            public Builder ssdGB(int ssdGB) {this.ssdGB = ssdGB; return this;}

            public Computer builder() {return new Computer(this);}
        }
    }
}
