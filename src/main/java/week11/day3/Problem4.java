package week11.day3;

/**
 * [연습 문제 4] 커맨드 패턴 기초
 * 문제: Command 인터페이스(execute())를 만들고, LightOnCommand 클래스를 구현해보세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO
        Light l = new Light();

        LightOnCommend on = new LightOnCommend(l);
        LightOffCommend off = new LightOffCommend(l);

        Remocont r = new Remocont();
        r.setCommend(on);
        r.pressBonten();

        r.setCommend(off);
        r.pressBonten();
    }

    interface Commend
    {
        void execute();
    }

    static class Light {
        void on() {System.out.println("조명을 켭니다.");}

        void off() {System.out.println("조명을 끕니다.");}
    }

    static class LightOnCommend implements Commend
    {
        private Light l;

        LightOnCommend(Light l) {this.l=l;}
        @Override
        public void execute() { l.on(); }
    }

    static class LightOffCommend implements Commend
    {
        private Light l;

        LightOffCommend(Light l) {this.l=l;}
        @Override
        public void execute() { l.off(); }
    }

    static class Remocont
    {
        Commend c;
        void setCommend(Commend c) {this.c=c;}
        void pressBonten() { c.execute(); }
    }
}
