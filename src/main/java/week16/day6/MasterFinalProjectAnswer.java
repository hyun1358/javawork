package week16.day6;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * [16주차 마스터 프로젝트] 통합 Task Manager (할 일 관리 시스템)
 * 
 * 문제:
 * 16주 동안 배운 모든 지식(OOP, 컬렉션, 스트림, 파일 입출력, 예외 처리)을 총동원하여 '할 일 관리 앱'을 완성하세요.
 * 1. Task 클래스 (id, description, isDone) 구현
 * 2. TaskManager 클래스에서 List<Task>를 관리하며 파일(tasks.txt)에 저장 및 불러오기 기능을 구현하세요.
 * 3. Stream API를 이용해 완료된 할 일, 미완료 할 일을 필터링하여 출력하세요.
 * 4. 예외 처리(파일이 없을 때 등)를 견고하게 작성하세요.
 *
 * 아래는 위 문제를 해결한 통합 정답 예시(Answer)입니다.
 */
public class MasterFinalProjectAnswer {
    private static final String FILE_NAME = "tasks.txt";

    public static void main(String[] args) {
        System.out.println("=== 16주 통합 마스터 프로젝트: Task Manager ===");
        TaskManager manager = new TaskManager(FILE_NAME);

        // 1. 초기 데이터 로드
        manager.loadTasks();

        // 2. 새로운 할 일 추가
        manager.addTask("자바 16주차 최종 복습하기");
        manager.addTask("미니 프로젝트 포트폴리오 정리");
        manager.addTask("네트워크 소켓 프로그래밍 테스트");

        // 3. 하나 완료 처리
        manager.completeTask(1); // 첫 번째 추가된 항목 완료 처리라 가정

        // 4. 상태 출력 (Stream 사용)
        manager.printAllTasks();
        manager.printPendingTasks();

        // 5. 파일에 저장
        manager.saveTasks();
    }
}

class Task implements Serializable {
    private static int counter = 1;
    private int id;
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.id = counter++;
        this.description = description;
        this.isDone = false;
    }

    public int getId() { return id; }
    public void setDone(boolean done) { isDone = done; }
    public boolean isDone() { return isDone; }

    @Override
    public String toString() {
        return "[" + (isDone ? "완료" : "대기") + "] " + id + ". " + description;
    }
}

class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private String filePath;

    public TaskManager(String filePath) {
        this.filePath = filePath;
    }

    public void addTask(String desc) {
        tasks.add(new Task(desc));
        System.out.println("새로운 할 일이 추가되었습니다: " + desc);
    }

    public void completeTask(int id) {
        tasks.stream()
             .filter(t -> t.getId() == id)
             .findFirst()
             .ifPresent(t -> {
                 t.setDone(true);
                 System.out.println("할 일이 완료 처리되었습니다: " + t);
             });
    }

    public void printAllTasks() {
        System.out.println("\n[전체 할 일 목록]");
        tasks.forEach(System.out::println);
    }

    public void printPendingTasks() {
        System.out.println("\n[미완료 할 일 목록]");
        List<Task> pending = tasks.stream()
                                  .filter(t -> !t.isDone())
                                  .collect(Collectors.toList());
        pending.forEach(System.out::println);
    }

    public void saveTasks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(tasks);
            System.out.println("\n[시스템] " + tasks.size() + "개의 할 일이 " + filePath + "에 성공적으로 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("[오류] 파일 저장에 실패했습니다: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadTasks() {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("[시스템] 기존 저장 파일이 없습니다. 새로 시작합니다.");
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            tasks = (List<Task>) ois.readObject();
            System.out.println("[시스템] " + tasks.size() + "개의 할 일을 불러왔습니다.");
        } catch (Exception e) {
            System.out.println("[오류] 파일 불러오기에 실패했습니다: " + e.getMessage());
        }
    }
}
