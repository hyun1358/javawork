package week11.day1;

public class Answer1 {
    public static void main(String[] args) {
        DBConnection db1 = DBConnection.getInstance();
        DBConnection db2 = DBConnection.getInstance();
        System.out.println(db1 == db2);
    }
}

class DBConnection {
    private static final DBConnection instance = new DBConnection();

    private DBConnection() {
    }

    public static DBConnection getInstance() {
        return instance;
    }
}
