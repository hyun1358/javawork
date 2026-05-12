package week06.day5;

public class Answer3 {
    public static void main(String[] args) {
        Printable p = new Document();
        p.print();
    }
}

interface Printable {
    void print();
}

class Document implements Printable {
    public void print() {
        System.out.println("문서 출력");
    }
}
