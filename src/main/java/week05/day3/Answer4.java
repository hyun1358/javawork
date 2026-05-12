package week05.day3;

public class Answer4 {
    public static void main(String[] args) {
        Product p = new Product();
        p.setName("");
        System.out.println("상품명: " + p.getName());
    }
}

class Product {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            this.name = "이름 없음";
        } else {
            this.name = name;
        }
    }
}
