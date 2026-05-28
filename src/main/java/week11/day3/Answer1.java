package week11.day3;

public class Answer1 {
    public static void main(String[] args) {
        Computer c = new Computer.Builder().cpu("i7").ram("16GB").build();
        System.out.println(c.cpu + ", " + c.ram);
    }

    static class Computer {
        String cpu, ram;

        private Computer(Builder b) {
            cpu = b.cpu;
            ram = b.ram;
        }

        public static class Builder {
            String cpu, ram;

            public Builder cpu(String c) {
                cpu = c;
                return this;
            }

            public Builder ram(String r) {
                ram = r;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }
}
