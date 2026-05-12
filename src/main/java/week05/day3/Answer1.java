package week05.day3;

public class Answer1 {
    public static void main(String[] args) {
        DogAnswer d = new DogAnswer();
        d.setName("멍멍이");
        System.out.println("개 이름: " + d.getName());
    }
}

class DogAnswer {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
