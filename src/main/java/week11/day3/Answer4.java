package week11.day3;

public class Answer4 {
    public static void main(String[] args) {
        Command cmd = new LightOnCommand(new Light());
        cmd.execute();
    }

    interface Command {
        void execute();
    }

    static class Light {
        void on() {
            System.out.println("불이 켜짐");
        }
    }

    static class LightOnCommand implements Command {
        Light light;
        LightOnCommand(Light l) {
            light = l;
        }
        public void execute() {
            light.on();
        }
    }
}
