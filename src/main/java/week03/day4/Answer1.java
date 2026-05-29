package week03.day4;

import java.util.Arrays;

public class Answer1 {
    // 메인 메서드: 문자열 배열을 정렬하고 출력하는 로직 실행
    public static void main(String[] args) {
        // 여러 과일 이름(문자열)을 담은 배열 생성 및 초기화
        String[] fruits = {"Orange", "Apple", "Banana", "Grape", "Melon"};
        
        // Arrays.sort() 메서드를 사용하여 문자열 배열을 사전순(알파벳순)으로 오름차순 정렬
        Arrays.sort(fruits);
        
        // 정렬된 배열의 내용을 Arrays.toString()을 이용해 보기 쉽게 출력
        System.out.println(Arrays.toString(fruits));
    }
}
