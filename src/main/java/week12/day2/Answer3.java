package week12.day2;

import java.io.*;
import java.net.*;

public class Answer3 {
    public static void main(String[] args) throws Exception {
        HttpURLConnection conn = (HttpURLConnection) new URL("https://jsonplaceholder.typicode.com/users/1").openConnection();
        if (conn.getResponseCode() == 200) {
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            System.out.println("내용: " + br.readLine());
        }
        conn.disconnect();
    }
}
