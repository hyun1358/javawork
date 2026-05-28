package week11.day2;

import java.util.*;

public class Answer3 {
    public static void main(String[] args) {
        Product p = new Product();
        p.addObserver(msg -> System.out.println("고객님, " + msg));
        p.setSoldOut();
    }

    interface ProdObserver {
        void update(String m);
    }

    static class Product {
        List<ProdObserver> obs = new ArrayList<>();
        void addObserver(ProdObserver o) {
            obs.add(o);
        }
        void setSoldOut() {
            for (ProdObserver o : obs) o.update("상품 품절 알림!");
        }
    }
}
