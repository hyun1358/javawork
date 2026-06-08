package week10.day6;

import java.io.*;
import java.util.*;

/**
 * [미니 프로젝트] Week 10 Day 6 — 종합 학생 성적 관리 시스템 (실습용)
 * <p>
 * 가이드(MiniProjectGuide.java)의 요구사항에 따라
 * Week 10에서 배운 모든 개념(List, Set, Map, 예외처리, I/O 직렬화)을
 * 활용하여 학생 성적 관리 시스템을 완성하세요.
 */
public class MiniProject {
    public static void main(String[] args) {
        // TODO: 아래의 클래스들과 메인 로직을 완성하세요.
        //
        // [구현 순서 가이드]
        //
        // Step 1. Student 클래스 작성 (이 파일 하단)
        //   - Serializable, Comparable<Student> 구현
        //   - 필드: studentId, name, HashMap<String, Integer> scores
        //   - equals() / hashCode() (studentId 기준)
        //   - getAverage() 메서드
        //   - compareTo() (평균 내림차순)
        //
        // Step 2. 커스텀 예외 클래스 작성 (이 파일 하단)
        //   - DuplicateStudentException
        //   - InvalidScoreException
        //
        // Step 3. 메인 로직 작성
        //   - ArrayList<Student>로 학생 관리 (Day1)
        //   - HashSet<String>으로 학번 중복 체크 (Day2)
        //   - HashMap<String, Integer>로 과목별 점수 관리 (Day3)
        //   - try-catch + 커스텀 예외로 입력 검증 (Day4)
        //   - ObjectInputStream/ObjectOutputStream으로 파일 저장/로드 (Day5)

        Scanner sc = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        Set<String> student_number = new HashSet<>();
        Map<String, Double> subjects_avg = new HashMap<>();

        File file = new File("students.dat");

        boolean system = true;

        if(file.exists())
        {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)))
            {
                students = (List<Student>) ois.readObject();
                for(int i = 0; i < students.size(); i++)
                {
                    student_number.add(String.valueOf(students.get(i).studentId));
                }
            }//try
            catch(IOException e)
            {
                e.printStackTrace();
            }
            catch(ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        }//if

        while (system)
        {
            System.out.println("=== 학생 성적 관리 시스템 ===");
            System.out.println("1. 학생 등록");
            System.out.println("2. 성적 입력");
            System.out.println("3. 전체 학생 조회 (성적순 정렬)");
            System.out.println("4. 학생 검색 (학번)");
            System.out.println("5. 과목별 평군 조회");
            System.out.println("6. 학생 삭제");
            System.out.println("7. 저장 후 종료");
            System.out.print("선택> ");
            int select = sc.nextInt();
            sc.nextLine();
            System.out.println();
            switch (select)
            {
                case 1:
                {
                    System.out.print("학번 > ");
                    int student_id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("이름 > ");
                    String studnet_name = sc.nextLine();
                    try
                    {
                        if (student_number.contains(String.valueOf(student_id)))
                        {
                            throw new DuplicateStudentException("학번중복");
                        }
                        students.add(new Student(student_id, studnet_name));
                        student_number.add(String.valueOf(student_id));
                        System.out.println("학생 등록 완료");
                    }
                    catch (DuplicateStudentException e)
                    {
                        System.out.println("[오류] " + e.getMessage());
                    }

                    System.out.println();
                    break;
                }//1
                case 2:
                {
                    System.out.print("학번 > ");
                    int student_id = sc.nextInt();
                    sc.nextLine();
                    Student student = null;
                    for(Student s : students)
                    {
                        if(student_id == s.studentId)
                        {
                            student = s;
                            break;
                        }
                    }
                    if(student == null)
                    {
                        System.out.println("존재하지않는 학번");
                        continue;
                    }
                    try
                    {
                        System.out.print("과목명: ");
                        String subjects = sc.nextLine();
                        System.out.print("점수: ");
                        int score = sc.nextInt();
                        sc.nextLine();
                        if(score < 0 || score > 100) throw new InvalidScoreException("0~100 범위만 가능");
                        student.setScores(subjects,score);
                    }
                    catch (NullPointerException e)
                    {
                        e.printStackTrace();
                    }
                    catch (InvalidScoreException e)
                    {
                        System.out.println("[오류] " + e.getMessage());
                    }
                    System.out.println();
                    break;
                }//2
                case 3:
                {

                    Collections.sort(students);
                    System.out.printf("%-5s\t%-4s\t%-20s\t%-5s\n", "학번", "이름", "과목별 점수", "평균");
                    for(Student s : students)
                    {
                        System.out.printf("%-5d\t%-4s\t",s.studentId,s.name);
                        StringJoiner sj = new StringJoiner(", ");
                        for(Map.Entry<String,Integer> entry : s.scores.entrySet())
                        {
                            sj.add(entry.getKey()+":"+entry.getValue());
                        }
                        System.out.print(sj);
                        System.out.printf("\t%-5.1f\n",s.getAverage());
                    }
                    System.out.println();
                    break;
                }//3
                case 4:
                {
                    Student student = null;
                    System.out.print("학번> ");
                    int studnet_num = sc.nextInt();
                    sc.nextLine();
                    for(Student s : students)
                    {
                        if(s.studentId == studnet_num)
                        {
                            student = s;
                        }
                    }

                    if(student == null)
                    {
                        System.out.println("학생 못찾음");
                        continue;
                    }
                    else
                    {
                        System.out.printf("%-5s\t%-4s\t%-20s\t%-5s\n", "학번", "이름", "과목별 점수", "평균");

                        System.out.printf("%-5d\t%-4s\t",student.studentId,student.name);
                        StringJoiner sj = new StringJoiner(", ");
                        for(Map.Entry<String,Integer> entry : student.scores.entrySet())
                        {
                            sj.add(entry.getKey()+":"+entry.getValue());
                        }
                        System.out.print(sj);
                        System.out.printf("\t%-5.1f\n",student.getAverage());

                        System.out.println();
                    }
                    break;
                }//4
                case 5:
                {
                    Map<String,Integer> totalMap = new HashMap<>();
                    Map<String,Integer> countMap = new HashMap<>();
                    for(Student s : students)
                    {
                        for(Map.Entry<String,Integer> entry : s.scores.entrySet())
                        {
                            totalMap.put(entry.getKey(),totalMap.getOrDefault(entry.getKey(),0) + entry.getValue());
                            countMap.put(entry.getKey(), countMap.getOrDefault(entry.getKey(),0)+1);
                        }
                    }

                    for(String key : totalMap.keySet())
                    {
                        subjects_avg.put(key,(double)totalMap.get(key) / countMap.get(key));
                    }

                    if (totalMap.isEmpty()) {
                        System.out.println("입력된 성적이 없습니다.");
                    } else {
                        for(Map.Entry<String, Double> entry : subjects_avg.entrySet())
                        {
                            String key = entry.getKey();
                            System.out.printf("  %s: %.1f점 (%d명)\n", key, entry.getValue(), countMap.get(key));
                        }
                    }
                    System.out.println();
                    break;
                }//5
                case 6:
                {
                    if(students.isEmpty())
                    {
                        System.out.println("학생이 리스트가 비어 있습니다.");
                        continue;
                    }
                    System.out.print("학번> ");
                    int student_num = sc.nextInt();
                    sc.nextLine();

                    boolean removed = students.removeIf(s->s.studentId == student_num);
                    if(removed)
                    {
                        student_number.remove(String.valueOf(student_num));
                        System.out.println("학생 삭제완료");
                    }
                    else System.out.println("학생을 찾지 못했습니다.");
                    break;
                }
                case 7:
                {
                    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file)))
                    {
                        oos.writeObject(students);
                        system = false;
                        System.out.println("종료");
                        break;
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }//switch
        }//while
    }
    static class Student implements Comparable<Student>, Serializable
    {
        private int studentId;
        private String name;
        private HashMap<String,Integer> scores = new HashMap<>();

        Student(int studentId, String name)
        {
            this.studentId=studentId;
            this.name=name;
        }

        Student(int studentId, String name, HashMap<String,Integer> scores)
        {
            this.studentId=studentId;
            this.name=name;
            this.scores=scores;
        }

        public void setScores(String subjects,Integer score)
        {
            scores.put(subjects,score);
        }

        public double getAverage()
        {
            if(scores == null || scores.isEmpty()) return 0.0;

            double avg = 0;
            for(Map.Entry<String,Integer> entry : scores.entrySet())
            {
                avg+=entry.getValue();
            }
            return avg / scores.size();
        }

        @Override
        public boolean equals(Object o)
        {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Student student = (Student)o;
            return this.studentId == student.studentId;
        }

        @Override
        public int hashCode()
        {
            return Integer.hashCode(this.studentId);
        }

        @Override
        public int compareTo(Student o)
        {
            return Double.compare(o.getAverage(), this.getAverage());
        }
    }

    static class DuplicateStudentException extends RuntimeException
    {
        DuplicateStudentException(String message)
        {
            super(message);
        }
    }

    static class InvalidScoreException extends RuntimeException
    {
        InvalidScoreException(String message)
        {
            super(message);
        }
    }
}
