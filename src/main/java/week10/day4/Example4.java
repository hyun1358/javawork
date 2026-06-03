package week10.day4;

import java.io.File;

/**
 * [실습 4] File.exists() / File.delete() (Problem 4 연계)
 * 
 * 비유: "내 컴퓨터의 파일 관리자"
 * java.io.File 객체를 이용해 특정 파일이 실제로 하드 디스크에 존재하는지 검사(exists())하고,
 * 존재할 경우 안전하게 영구 삭제(delete())하는 파일 메타데이터 제어 기법을 공부합니다.
 */
public class Example4 {
    public static void main(String[] args) {
        System.out.println("=== [실습 4] File 파일 존재 여부 조회 및 삭제 예제 ===");
        
        File file = new File("mydata.txt");

        // 파일이 실제로 존재하는지 체크
        if (file.exists()) {
            System.out.println("-> '" + file.getName() + "' 파일이 확인되었습니다. 삭제를 시작합니다.");
            
            // 실제 디스크에서 영구 삭제
            boolean deleted = file.delete(); 
            System.out.println("-> 삭제 성공 여부: " + deleted);
        } else {
            System.out.println("-> 파일이 존재하지 않습니다. 먼저 실습 1이나 3을 가동해 주세요!");
        }
    }
}
