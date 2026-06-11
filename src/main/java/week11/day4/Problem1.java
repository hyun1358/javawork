package week11.day4;

/**
 * [연습 문제 1] 요일 Enum
 * 문제: MONDAY ~ SUNDAY 까지 Enum을 만들고 한국어 이름을 출력하도록 추가하세요.
 */
public class Problem1 {
    public static void main(String[] args)
    {
        // TODO
        for(DayofWeek day : DayofWeek.values())
        {
            System.out.println(day.name() + " -> " + day.getKoreaName());
        }
    }

    enum DayofWeek
    {
        MONDAY("월요일"),TUESEDAY("화요일"),WEDNSEDAY("수요일"),THURSDAY("목요일"),FRIDAY("금요일"),SATURDAY("토요일"),SUNDAY("일요일");

        public final String koreaName;

        DayofWeek(String korName) { this.koreaName=korName;}

        public String getKoreaName() {return koreaName;}

    }
}
