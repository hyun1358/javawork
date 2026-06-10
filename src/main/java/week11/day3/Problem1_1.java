package week11.day3;

/**
 * [보충 문제 1_1] Car 빌더
 * 문제: model(모델명), color(색상), sunroof(선루프 여부), navigation(네비게이션 여부)을 
 *      메서드 체이닝으로 설정할 수 있는 Car 빌더를 구현하세요.
 *      (sunroof와 navigation의 기본값은 false로 설정하세요.)
 */
public class Problem1_1 {
    public static void main(String[] args)
    {
        // TODO: 아래 코드가 주석 해제되었을 때 정상 작동하도록 Car 클래스와 Builder 클래스를 완성하세요.

        Car car = new Car.Builder()
                .model("소나타")
                .color("화이트")
                .sunroof(true)
                .build();

        System.out.println("모델: " + car.getModel() + ", 색상: " + car.getColor() 
                + ", 선루프: " + car.isSunroof() + ", 네비: " + car.isNavigation());

    }

    static class Car
    {
        private String model;
        private String color;
        private boolean sunroof;
        private boolean navigation;

        // private 생성자 작성
        // TODO
        private Car(Builder b)
        {
            this.model = b.model;
            this.color = b.color;
            this.sunroof = b.sunroof;
            this.navigation = b.navigation;
        }
        // Getter 메서드들
        public String getModel() { return model; }
        public String getColor() { return color; }
        public boolean isSunroof() { return sunroof; }
        public boolean isNavigation() { return navigation; }

        // static 내부 Build 클래스 작성
        // TODO
        static class Builder
        {
            private String model;
            private String color;
            private boolean sunroof;
            private boolean navigation;

            Builder model(String model) {this.model=model; return this;}
            Builder color(String color) {this.color=color; return this;}
            Builder sunroof(boolean sunroof) {this.sunroof=sunroof; return this;}
            Builder navigation(boolean navigation) {this.navigation=navigation; return this;}

            Car build() {return new Car(this);}
        }
    }
}
