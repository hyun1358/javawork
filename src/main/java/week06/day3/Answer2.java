package week06.day3;

public class Answer2 {
    public static void main(String[] args) {
        Item item = new Computer();
        item.print(); // Computer의 print()가 호출됨
    }
}

class Item {
    void print() {
        System.out.println("아이템");
    }
}

class Computer extends Item {
    @Override
    void print() {
        System.out.println("컴퓨터");
    }
}
