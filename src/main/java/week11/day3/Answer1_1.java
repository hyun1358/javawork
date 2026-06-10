package week11.day3;

// [보충 문제 1_1 정답] Car 빌더 패턴 예시 답안
public class Answer1_1 {
    public static void main(String[] args) {
        Car car = new Car.Builder()
                .model("소나타")
                .color("화이트")
                .sunroof(true)
                .build();

        System.out.println("모델: " + car.getModel() + ", 색상: " + car.getColor() 
                + ", 선루프: " + car.isSunroof() + ", 네비: " + car.isNavigation());
    }

    static class Car {
        private final String model;
        private final String color;
        private final boolean sunroof;
        private final boolean navigation;

        private Car(Builder builder) {
            this.model = builder.model;
            this.color = builder.color;
            this.sunroof = builder.sunroof;
            this.navigation = builder.navigation;
        }
        
        public String getModel() { return model; }
        public String getColor() { return color; }
        public boolean isSunroof() { return sunroof; }
        public boolean isNavigation() { return navigation; }

        public static class Builder {
            private String model;
            private String color;
            private boolean sunroof = false; // 기본값 false 설정
            private boolean navigation = false; // 기본값 false 설정

            public Builder model(String model) {
                this.model = model;
                return this;
            }

            public Builder color(String color) {
                this.color = color;
                return this;
            }

            public Builder sunroof(boolean sunroof) {
                this.sunroof = sunroof;
                return this;
            }

            public Builder navigation(boolean navigation) {
                this.navigation = navigation;
                return this;
            }

            public Car build() {
                return new Car(this);
            }
        }
    }
}
