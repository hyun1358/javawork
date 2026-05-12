package week10.day6;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MiniProjectAnswer {
    private static final String FILE_NAME = "tasks.dat";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        // 시작 시 데이터 로드
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                tasks = (ArrayList<Task>) in.readObject();
                System.out.println("기존 할 일 목록을 불러왔습니다.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        boolean run = true;
        while (run) {
            System.out.println("\n1.추가 2.조회 3.완료 4.종료");
            System.out.print("선택> ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    System.out.print("새 할일: ");
                    tasks.add(new Task(sc.nextLine()));
                    System.out.println("추가되었습니다.");
                    break;
                case 2:
                    System.out.println("--- 할 일 목록 ---");
                    for (int i = 0; i < tasks.size(); i++) {
                        Task t = tasks.get(i);
                        System.out.printf("%d. [%s] %s\n", i + 1, t.done ? "O" : "X", t.name);
                    }
                    break;
                case 3:
                    System.out.print("완료할 번호: ");
                    int num = sc.nextInt();
                    if (num >= 1 && num <= tasks.size()) {
                        tasks.get(num - 1).done = true;
                        System.out.println("완료 처리됨!");
                    }
                    break;
                case 4:
                    // 종료 시 데이터 저장
                    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
                        out.writeObject(tasks);
                        System.out.println("데이터를 안전하게 저장했습니다.");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    run = false;
                    break;
            }
        }
        sc.close();
    }
}

class Task implements Serializable {
    String name;
    boolean done;

    Task(String n) {
        name = n;
        done = false;
    }
}
