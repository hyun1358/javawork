package week11.day1;

public class Answer2 {
    public static void main(String[] args) {
        LazySingleton s1 = LazySingleton.getInstance();
    }

    static class LazySingleton {
        private static LazySingleton instance;
        private LazySingleton() {}
        public static synchronized LazySingleton getInstance() {
            if (instance == null) {
                instance = new LazySingleton();
            }
            return instance;
        }
    }
}
