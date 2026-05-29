package week04.day5;

public class Answer1 {
    // 메인 메서드: 여러 개의 메서드를 조합하여 정형화된 출력을 테스트
    public static void main(String[] args) {
        // 헤더 출력 메서드 호출 (제목 전달)
        printHeader("학생 정보");
        // 데이터 출력 메서드 호출 (라벨과 값 전달)
        printData("이름", "홍길동");
        // 푸터 출력 메서드 호출
        printFooter();
    }

    // printHeader 메서드: 출력물의 상단 부분(헤더)을 꾸며주는 역할
    public static void printHeader(String title) {
        System.out.println("---------");
        System.out.println(title); // 전달받은 제목 출력
        System.out.println("---------");
    }

    // printData 메서드: 실제 데이터(라벨과 값)를 형식에 맞게 출력하는 역할
    public static void printData(String label, String value) {
        System.out.println(label + ": " + value);
    }

    // printFooter 메서드: 출력물의 하단 부분(푸터)을 마무리하는 역할
    public static void printFooter() {
        System.out.println("---------");
    }
}
