package week11.day4;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class Example {
    public static void main(String[] args) {

        System.out.println("=== Lab 1: Enum — 요일 ===");
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println(day.name() + " → " + day.getKoreanName());
        }

        DayOfWeek today = DayOfWeek.MONDAY;
        System.out.println("오늘: " + today + " (" + today.getKoreanName() + ")");

        System.out.println("\n=== Lab 2: Enum 상태 머신 — OrderStatus ===");
        OrderStatus status = OrderStatus.PENDING;
        System.out.println("초기 상태: " + status);

        status = status.next(); // PENDING → PAID
        System.out.println("다음 상태: " + status);

        status = status.next(); // PAID → SHIPPED
        System.out.println("다음 상태: " + status);

        status = status.next(); // SHIPPED → 더 이상 없음 (자기 자신 유지)
        System.out.println("다음 상태: " + status);

        System.out.println("\n=== Lab 3 & 5: @NotNull 어노테이션 + 리플렉션 검사 ===");
        Field[] fields = Member.class.getDeclaredFields();
        System.out.println("Member 클래스의 @NotNull 필드:");
        for (Field f : fields) {
            if (f.isAnnotationPresent(NotNull.class)) {
                System.out.println("  → @NotNull 필드: " + f.getName() + " (타입: " + f.getType().getSimpleName() + ")");
            }
        }

        Member m = new Member(null, "test@test.com");
        validateNotNull(m);

        System.out.println("\n=== Lab 4: @Deprecated ===");
        LegacyService service = new LegacyService();
        service.newMethod(); 

        @SuppressWarnings("deprecation")
        String result = service.oldMethod();
        System.out.println("구형 메서드 결과: " + result);
    }

    static void validateNotNull(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(NotNull.class)) {
                f.setAccessible(true);
                try {
                    if (f.get(obj) == null) {
                        System.out.println("검증 실패: '" + f.getName() + "' 필드는 null이면 안 됩니다!");
                    } else {
                        System.out.println("검증 통과: '" + f.getName() + "' = " + f.get(obj));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    enum DayOfWeek {
        MONDAY("월요일"), TUESDAY("화요일"), WEDNESDAY("수요일"),
        THURSDAY("목요일"), FRIDAY("금요일"), SATURDAY("토요일"), SUNDAY("일요일");
        private final String koreanName;
        DayOfWeek(String koreanName) { this.koreanName = koreanName; }
        public String getKoreanName() { return koreanName; }
    }

    enum OrderStatus {
        PENDING, PAID, SHIPPED, DELIVERED;
        public OrderStatus next() {
            OrderStatus[] values = OrderStatus.values();
            int next = this.ordinal() + 1;
            return next < values.length ? values[next] : this;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface NotNull {}

    static class Member {
        @NotNull private String name;
        private String email;
        Member(String name, String email) {
            this.name  = name;
            this.email = email;
        }
    }

    static class LegacyService {
        @Deprecated public String oldMethod() { return "구형 방식으로 처리됨"; }
        public void newMethod() { System.out.println("새로운 방식으로 처리됨 (권장)"); }
    }
}
