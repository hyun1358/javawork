package week10.day4;

import java.io.File;

/**
 * [연습 문제 4] 파일 존재 확인 및 삭제
 * 문제: "mydata.txt" 파일이 존재하는지 검사하고, 존재하면 삭제하는 코드를 작성하세요.
 */
public class Problem4 {
    public static void main(String[] args)
    {
        // TODO
        File file = new File("mydata.txt");

        if(file.exists())
        {
            System.out.println("파일이름 : " +file.getName() + "의 존재를 확인 했습니다 삭제를 진행합니다.");
            boolean isDelet = file.delete();
            System.out.println("삭제여부: " + isDelet);
        }
        else
        {
            System.out.println("파일이 존재 하지 않습니다.");
        }
    }
}
