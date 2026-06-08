package week03.day6;

import java.util.Objects;
import java.util.Scanner;

/**
 * [종합 미니 프로젝트 정답 - 신규] Week 03 Day 6
 * 「 스마트 쇼핑몰 회원 및 포인트 관리 시스템 」
 */
public class MiniProjectAnswer_New {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Member[] members = new Member[10];
        int memberCount = 0;

        System.out.println("=== 회원 등록 시스템 (최대 10명) ===");
        System.out.println("가입 형식: [아이디],[이름],[등급(일반/VIP)] (예: user01,홍길동,VIP)");
        System.out.println("입력을 마치려면 'exit'를 입력하세요.");

        // Day 4: 반복문과 String 활용 회원 등록
        while (memberCount < 10) {
            System.out.print("입력> ");
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            // Day 4: split()을 통한 문자열 파싱
            String[] tokens = input.split(",");
            if (tokens.length < 3) {
                System.out.println("입력 형식이 맞지 않습니다. 다시 입력해주세요.");
                continue;
            }

            String id = tokens[0].trim();
            String name = tokens[1].trim();
            String grade = tokens[2].trim();

            // Day 3: equals()를 이용한 중복 아이디 검사
            // 가상 객체를 만들어 기존 회원과 비교
            Member newMember;
            if (grade.equalsIgnoreCase("VIP")) {
                newMember = new VipMember(id, name);
            } else {
                newMember = new Member(id, name);
            }

            boolean isDuplicate = false;
            for (int i = 0; i < memberCount; i++) {
                if (members[i].equals(newMember)) { // equals 오버라이딩 확인
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate) {
                System.out.println("[오류] 이미 존재하는 아이디입니다. 등록 실패.");
            } else {
                members[memberCount++] = newMember;
                System.out.println("정상적으로 등록되었습니다.");
            }
        }

        // 포인트 적립 진행
        System.out.println("\n=== 포인트 적립 진행 ===");
        for (int i = 0; i < memberCount; i++) {
            System.out.printf("[%s] 회원의 구매 금액을 입력하세요: ", members[i].getName());
            String priceStr = sc.nextLine().trim();

            try {
                // Day 5: 래퍼 클래스 Integer.parseInt() 적용
                int price = Integer.parseInt(priceStr);
                
                // Day 1 & Day 2: 다형성과 오버라이딩을 활용한 포인트 적립
                members[i].calculatePoint(price);
                System.out.printf("-> 적립 완료! 현재 포인트: %d P\n", members[i].getPoint());
            } catch (NumberFormatException e) {
                System.out.println("[오류] 올바른 숫자 금액을 입력해 주세요. 적립이 건너뛰어집니다.");
            }
        }

        // Day 3: toString()을 통한 회원 목록 최종 출력
        System.out.println("\n=== 최종 회원 목록 및 포인트 현황 ===");
        for (int i = 0; i < memberCount; i++) {
            // toString()이 오버라이딩되어 이름이 마스킹되어 나타남
            System.out.println(members[i].toString());
        }

        sc.close();
    }
}

// Day 1: Member 부모 클래스 설계
class Member {
    private String id;
    private String name;
    protected int point; // 자식 클래스에서 접근 가능하도록 protected

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
        this.point = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Day 5: 오토박싱/언박싱 활용을 위해 Integer 래퍼 사용 가능
    public Integer getPoint() {
        return point; // 오토박싱
    }

    // Day 2: 포인트 계산 메서드 (일반 회원 1% 적립)
    public void calculatePoint(int price) {
        this.point += (int) (price * 0.01);
    }

    // Day 3: equals & hashCode 오버라이딩
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Day 3: toString() 오버라이딩
    // Day 4: String substring() & StringBuilder를 이용한 마스킹 처리
    @Override
    public String toString() {
        String maskedName = name;
        if (name.length() >= 2) {
            StringBuilder sb = new StringBuilder();
            sb.append(name.charAt(0));
            for (int i = 1; i < name.length() - 1; i++) {
                sb.append("*");
            }
            sb.append(name.charAt(name.length() - 1));
            maskedName = sb.toString();
        }
        return String.format("[일반] 아이디: %s, 이름: %s, 누적 포인트: %d P", id, maskedName, point);
    }
}

// Day 1: VipMember 자식 클래스 설계
class VipMember extends Member {
    public VipMember(String id, String name) {
        // 부모 생성자 호출
        super(id, name);
    }

    // Day 2: 메서드 오버라이딩 (VIP 회원 5% 적립)
    @Override
    public void calculatePoint(int price) {
        this.point += (int) (price * 0.05);
    }

    // Day 3: toString() 재정의
    @Override
    public String toString() {
        // 부모의 maskedName을 직접 만들거나, 부모 필드를 활용
        String name = getName();
        String maskedName = name;
        if (name.length() >= 2) {
            StringBuilder sb = new StringBuilder();
            sb.append(name.charAt(0));
            for (int i = 1; i < name.length() - 1; i++) {
                sb.append("*");
            }
            sb.append(name.charAt(name.length() - 1));
            maskedName = sb.toString();
        }
        return String.format("[★VIP★] 아이디: %s, 이름: %s, 누적 포인트: %d P (무료 배송 대상)", getId(), maskedName, getPoint());
    }
}
