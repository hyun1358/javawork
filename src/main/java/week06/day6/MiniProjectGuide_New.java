package week06.day6;

/**
 * [종합 미니 프로젝트 가이드 - 신규] Week 06 Day 6
 * 「 개인정보 마스킹 기능이 포함된 스마트 일기장 및 백업 시스템 」
 * 
 * [목적]
 *   Week 06에서 배운 파일 입출력(문자/바이트 스트림), 객체 직렬화, java.nio 및 정규표현식을 
 *   모두 활용하여 보안 일기장 프로그램을 작성합니다.
 * 
 * [활용 개념 — Day별 대응]
 *   - Day 1 (파일 입출력 기초 - 문자 스트림):
 *       사용자가 작성한 일기 원본 텍스트를 BufferedReader/BufferedWriter를 사용해 
 *       "diary_raw.txt" 파일에 한 줄씩 쓰고 읽는 기능 구현.
 *   - Day 2 & Day 3 (바이트 스트림 & 직렬화):
 *       일기 객체(DiaryEntry)를 생성하고 이를 ObjectOutputStream을 사용해 
 *       바이너리 파일 "diary_backup.dat"로 직렬화하여 백업.
 *       비밀번호(password) 필드는 transient로 지정하여 직렬화(백업) 대상에서 제외함으로써 보안 유지.
 *   - Day 4 (java.nio):
 *       NIO의 Path와 Files 클래스를 사용하여 파일 및 디렉토리의 존재 여부 확인, 생성 및 경로 관리 구현.
 *   - Day 5 (문자열 포맷과 정규식):
 *       일기를 저장할 때 정규표현식(Pattern, Matcher)을 사용해 본문 내 이메일 주소(예: user@example.com)나 
 *       전화번호(예: 010-1234-5678)를 탐색하여 "****"로 마스킹 처리한 뒤 저장.
 *       String.format()을 사용해 일기 정보(날짜, 제목, 마스킹된 본문)를 깔끔하게 서식화하여 출력.
 * 
 * [상세 요구사항]
 *   1. DiaryEntry 클래스 설계:
 *      - java.io.Serializable 구현
 *      - 필드: private String date, private String title, private String content, private transient String password
 *      - 생성자 및 Getter/Setter 구현
 *      - toString() 구현 (출력 포맷 적용)
 *   2. 메인 프로그램 흐름:
 *      - 시작 시 java.nio의 Files.exists()를 사용해 백업 파일("diary_backup.dat")이 있는지 확인.
 *      - 백업 파일이 존재하면 ObjectInputStream(바이트 스트림)을 통해 역직렬화하여 기존 일기 데이터를 복원.
 *      - 메뉴 구성:
 *        * 1. 새 일기 작성 (개인정보 정규식 마스킹 및 raw 텍스트 파일 저장 기능 포함)
 *        * 2. 일기 목록 조회 (String.format 포맷팅 적용)
 *        * 3. 백업 데이터 파일로 저장 (객체 직렬화 적용)
 *        * 4. 종료
 *   3. 일기 작성 시 개인정보 보호 마스킹:
 *      - 본문에 이메일 형식(예: abcd@efg.com)이나 전화번호 형식(예: 010-xxxx-xxxx)이 포함되어 있으면 
 *        정규식 패턴 매칭을 통해 해당 텍스트를 " [개인정보 마스킹] " 으로 치환(replaceAll)하여 일기 객체에 저장.
 */
public class MiniProjectGuide_New {
}
