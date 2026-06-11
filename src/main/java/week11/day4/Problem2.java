package week11.day4;

/**
 * [연습 문제 2] Enum 상태 머신
 * 문제: OrderStatus Enum에 next() 메서드를 추가하여 PENDING -> PAID -> SHIPPED 로 전환되게 하세요.
 */
public class Problem2 {
    public static void main(String[] args)
    {
        // TODO

        OrderStatus order = OrderStatus.PENDING;
        System.out.println("초기상태 :" + order.name()+"/"+order.getOrderKorea());

        order = order.next();
        System.out.println("next() :" + order.name()+"/"+order.getOrderKorea());

        order = order.next();
        System.out.println("next() :" + order.name()+"/"+order.getOrderKorea());

        order = order.next();
        System.out.println("next() :" + order.name()+"/"+order.getOrderKorea());
    }

    enum OrderStatus
    {
        PENDING("결제중"),PAID("결제완료"),SHIPPED("배송중");
        private final String status;

        OrderStatus(String status) {this.status = status;}

        public String getOrderKorea() { return status;}

        public OrderStatus next()
        {
            OrderStatus[] temp = OrderStatus.values();
            int num = this.ordinal() + 1;
            return num < temp.length ? temp[num] : this;
        }
    }
}
