package week11.day2;

import java.util.ArrayList;
import java.util.List;

/**
 * [연습 문제 3] 상품 품절 알림 (옵저버)
 * 문제: Product가 품절될 때 구독한 User들에게 알림을 보내는 코드를 작성하세요.
 */
public class Problem3 {
    public static void main(String[] args)
    {
        // TODO
        Product product = new Product("MacBookAir Pro 4");
        product.subscribe(new User("홍길동"));
        product.subscribe(new User("김철수"));
        product.subscribe(new User("이유리"));

        product.setSoldOut();

    }

    interface ObserverStrategy
    {
        void notification(String message);
    }

    static class User implements ObserverStrategy
    {
        String name;

        User(String name) {this.name = name;}

        @Override
        public void notification(String message)
        {
            System.out.println(name+"님 :" + message);
        }
    }

    static class Product
    {
        String name;
        List<User> users = new ArrayList<>();

        Product(String name) {this.name = name;}

        public void subscribe(User user)
        {
            users.add(user);
        }

        public void setSoldOut()
        {
            System.out.println("=== "+ name + "품절 발생 ===");
            String message = name+" 상품이 품절되었습니다.";
            for(User u : users)
            {
                u.notification(message);
            }
        }
    }
}
