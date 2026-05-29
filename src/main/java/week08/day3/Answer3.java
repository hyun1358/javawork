package week08.day3;

import java.util.*;

/**
 * Comparator 인터페이스를 익명 클래스로 구현하여 특정 기준(이름 오름차순)으로 정렬하는 예제입니다.
 */
public class Answer3 {
    public static void main(String[] args) {
        List<Stud3> list = Arrays.asList(new Stud3("Kim"), new Stud3("Park"), new Stud3("Lee"));
        // sort 메서드에 외부 정렬 기준인 Comparator의 익명 구현 객체를 전달합니다.
        list.sort(new Comparator<Stud3>() {
            // 두 객체의 이름을 String의 compareTo 메서드로 비교하여 오름차순 정렬합니다.
            public int compare(Stud3 o1, Stud3 o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        for (Stud3 s : list) System.out.println(s.name);
    }
}

class Stud3 {
    String name;

    Stud3(String n) {
        name = n;
    }
}
