package week12.day5;

// 공통 인터페이스를 구현하여 데이터를 파일에 저장하는 구체 클래스 예제입니다.
public class Answer2 {
    // 메인 메서드
    public static void main(String[] args) {
    }

    // 데이터 저장소 인터페이스
    interface DataRepository {
        void save(String data);
        String get();
    }

    // DataRepository 인터페이스를 구현한 파일 기반 저장소 클래스
    static class FileDataRepository implements DataRepository {
        // 인터페이스의 save 메서드를 오버라이딩하여 파일 저장 로직(가짜)을 구현합니다.
        @Override
        public void save(String data) {
            System.out.println("파일에 저장: " + data);
        }
        
        // 인터페이스의 get 메서드를 오버라이딩하여 파일 조회 로직을 구현합니다.
        @Override
        public String get() {
            return "파일 데이터";
        }
    }
}
