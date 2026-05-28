package week10.day4;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 * [예습 파일] Week 10 Day 4 — 파일 입출력 기초
 * 
 * [핵심 개념: 데이터의 영속성 보관과 IO 스트림]
 * 1. 입출력 스트림 (Input / Output Stream):
 *    - 자바 밖의 파일이나 네트워크 장치 간에 데이터가 단방향으로 흐르는 통로(Stream)입니다.
 *    - 바이트 스트림 (InputStream/OutputStream): 이미지, 동영상 등 모든 이진 데이터를 1바이트씩 그대로 주고받는 저수준 스트림입니다.
 *    - 문자 스트림 (Reader/Writer): 텍스트 파일(메모장 등)을 2바이트 유니코드 문자열로 자동 인코딩 변환하여 가독성 높게 전달하는 텍스트 전용 스트림입니다.
 * 
 * 2. 리소스 정리의 강제성:
 *    - 파일 IO 객체들은 다 쓰고 나면 반드시 JVM 외부의 파일 핸들 열쇠를 되돌려주기 위해 `.close()`를 호출해야 다른 프로세스가 해당 파일을 손댈 수 있습니다. (try-with-resources 필수)
 */
public class Preview {
    public static void main(String[] args) throws Exception {
        File file = new File("test.txt");

        // 1. 쓰기
        try (FileWriter fw = new FileWriter(file)) {
            fw.write("Hello Java IO\n");
            fw.write("두 번째 줄입니다.");
        }
        System.out.println("파일 생성 및 쓰기 완료");

        // 2. 읽기
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("--- 파일 내용 ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        // 뒷정리 삭제 (테스트용)
        if (file.exists()) file.delete();
    }
}
