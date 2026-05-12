package week12.day3;

/**
 * [예습 파일] Week 12 Day 3 — JSON 파싱
 * (실제 현업에서는 Gson이나 Jackson 라이브러리를 사용합니다)
 */
public class Preview {
    public static void main(String[] args) {
        String json = "{\"name\": \"홍길동\", \"age\": 20}";
        System.out.println("받아온 JSON 원본: " + json);

        // 원시적인 파싱 (라이브러리 없이)
        String[] parts = json.replace("{", "").replace("}", "").replace("\"", "").split(",");
        for (String p : parts) {
            String[] kv = p.split(":");
            System.out.println(kv[0].trim() + " 값은 " + kv[1].trim());
        }
    }
}
