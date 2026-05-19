package week08.japaneseWordQuiz;

import java.util.*;

public class JapaneseWordQuiz
{

    public static void main(String[] args)
    {

        // 단어장 생성
        HashMap<String, String> japanWord = new HashMap<>();

        // 초기 데이터
        init(japanWord);

        // 입력 객체
        Scanner sc = new Scanner(System.in);

        while (true)
        {

            System.out.println("===============");
            System.out.println("1. 일→한");
            System.out.println("2. 한→일");
            System.out.println("3. 단어 등록");
            System.out.println("4. 종료");
            System.out.println("===============");

            System.out.print("선택 >> ");

            int mode = sc.nextInt();
            sc.nextLine(); // 버퍼 제거

            switch (mode)
            {
                // 일본어 -> 한국어
                case 1:

                    List<String> keys = new ArrayList<>(japanWord.keySet());

                    Collections.shuffle(keys);

                    for (String key : keys)
                    {

                        System.out.printf("문제: %s 의 뜻은? (0 입력시 종료)\n", key);

                        System.out.print("정답 >> ");

                        String answer = sc.nextLine();

                        if (answer.equals("0"))
                        {
                            break;
                        }

                        if (japanWord.get(key).equals(answer))
                        {
                            System.out.println("정답!");
                        }
                        else
                        {
                            System.out.printf("오답! 정답은 %s\n", japanWord.get(key));
                        }

                        System.out.println();
                    }

                    break;

                // 한국어 -> 일본어
                case 2:

                    // TODO

                    break;

                // 단어 등록
                case 3:

                    System.out.print("일본어 >> ");
                    String jp = sc.nextLine();

                    System.out.print("뜻 >> ");
                    String ko = sc.nextLine();

                    japanWord.put(jp, ko);

                    System.out.println("등록 완료!");

                    break;

                // 종료
                case 4:

                    System.out.println("프로그램을 종료합니다.");
                    return;

                default:

                    System.out.println("잘못된 입력입니다.");
            }
        }
    }

    /**
     * 초기 단어 데이터
     */
    public static void init(HashMap<String, String> map)
    {

        // 음식
        map.put("すし(寿司)", "초밥");
        map.put("てんどん(天丼)", "텐동");
        map.put("ジュース", "주스");
        map.put("パン", "빵");
        map.put("ビール", "맥주");
        map.put("べんとう(弁当)", "도시락");
        map.put("えきべん(駅弁)", "역도시락");
        map.put("ラーメン", "라면");
        map.put("ケーキ", "케이크");
        map.put("ぎょうざ(餃子)", "만두");
        map.put("まぐろ(鮪)", "참치");
        map.put("うに(雲丹)", "성게알");
        map.put("えび(海老)", "새우");
        map.put("しょうゆ(醤油)", "간장");
        map.put("まつり(祭り)", "축제");
        map.put("おすすめ", "추천");

        // 사람
        map.put("がくせい(学生)", "학생");
        map.put("かいしゃいん(会社員)", "회사원");
        map.put("しゅふ(主婦)", "주부");
        map.put("かんこくじん(韓国人)", "한국인");
        map.put("にほんじん(日本人)", "일본인");
        map.put("せんせい(先生)", "선생님");
        map.put("ともだち(友達)", "친구");
        map.put("ひと(人)", "사람");
        map.put("わたし(私)", "나");

        // 여행 및 장소
        map.put("バス", "버스");
        map.put("でんしゃ(電車)", "전철");
        map.put("タクシー", "택시");
        map.put("くるま(車)", "자동차");
        map.put("パスポート", "여권");
        map.put("チケット", "티켓");
        map.put("にもつ(荷物)", "짐");
        map.put("ちず(地図)", "지도");
        map.put("あさくさ(浅草)", "아사쿠사");
        map.put("スカイツリー", "스카이트리");
        map.put("かんこう(観光)", "관광");
        map.put("ビジネス", "비즈니스");
        map.put("エレベーター", "엘리베이터");
        map.put("おてあらい(お手洗い)", "화장실");
        map.put("にほん(日本)", "일본");
        map.put("ソウル", "서울");
        map.put("かんこうち(観光地)", "관광지");
        map.put("へや(部屋)", "방");

        // 숫자
        map.put("ひとつ(一つ)", "한개");
        map.put("ふたつ(二つ)", "두개");
        map.put("みっつ(三つ)", "세개");
        map.put("よっつ(四つ)", "네개");
        map.put("いつつ(五つ)", "다섯개");
        map.put("むっつ(六つ)", "여섯개");

        // 형용사
        map.put("かんたん(簡単)", "간단");
        map.put("べんり(便利)", "편리");
        map.put("ひつよう(必要)", "필요");
        map.put("しんせん(新鮮)", "신선");
        map.put("ゆうめい(有名)", "유명");
        map.put("すき(好き)", "좋아함");
        map.put("おいしい(美味しい)", "맛있다");
        map.put("かわいい", "귀엽다");
        map.put("たかい(高い)", "비싸다");
        map.put("やすい(安い)", "싸다");
        map.put("さむい(寒い)", "춥다");
        map.put("あつい(暑い)", "덥다");
        map.put("ちいさい(小さい)", "작다");
        map.put("おおきい(大きい)", "크다");
        map.put("とおい(遠い)", "멀다");
        map.put("じょうず(上手)", "능숙하다");
        map.put("ほしい(欲しい)", "갖고싶다");
        map.put("たくさん", "많이");
        map.put("あまり", "그다지");

        // 시간 및 질문
        map.put("きょう(今日)", "오늘");
        map.put("いま(今)", "지금");
        map.put("なに(何)", "무엇");
        map.put("どこ", "어디");
        map.put("いつ", "언제");
        map.put("だれ(誰)", "누구");
        map.put("ここ", "여기");
        map.put("とても", "매우");
        map.put("わかりました", "알겠습니다");
        map.put("あります", "있다");
        map.put("ありました", "있었다");
        map.put("どこに", "어디에");
    }
}