package week09.day6;

/**
 * [종합 미니 프로젝트 가이드 - 신규] Week 09 Day 6
 * 「 도서 대여 파일 장부 및 상태 인덱스 관리 시스템 」
 * 
 * [목적]
 *   Week 09에서 배운 파일 및 디렉토리 제어, 다양한 입출력 스트림(문자/바이트 스트림), 
 *   특수 스트림(DataStream), 임의 접근 파일(RandomAccessFile), 그리고 Properties 설정을 
 *   모두 활용하여 로컬 파일 기반의 데이터 저장 엔진을 직접 구축합니다.
 * 
 * [활용 개념 — Day별 대응]
 *   - Day 1 (File 클래스):
 *       데이터를 저장할 디렉토리("data")를 만들고 파일의 존재 여부 및 메타데이터를 관리.
 *   - Day 2 (문자 스트림):
 *       도서 대출 이력 파일("data/rentals.txt")을 BufferedReader와 BufferedWriter를 사용해 누적 기록 및 한 줄씩 읽기.
 *   - Day 3 (바이트 스트림):
 *       바이트 스트림(FileInputStream / FileOutputStream)과 버퍼를 사용해 텍스트 장부를 
 *       "data/rentals_backup.txt" 로 고속 백업 복사하는 메서드 구현.
 *   - Day 4 (DataStream & RandomAccessFile):
 *       RandomAccessFile의 seek() 메서드를 사용하여, 고정 길이 레코드 포맷으로 만들어진 
 *       도서 인덱스 파일("data/books.dat")의 특정 위치로 이동해 상태(대출중 여부)를 직접 수정.
 *   - Day 5 (Properties & Scanner):
 *       프로그램 설정 파일("data/config.properties")을 Properties 클래스로 로드하여 도서관명, 연체 벌금 기준 등을 세팅.
 *       Scanner를 사용하여 파일 내부의 텍스트 데이터를 쉼표(,) 기준으로 파싱하여 활용.
 * 
 * [상세 요구사항]
 *   1. 환경 설정 로드 (Properties):
 *      - "data/config.properties" 파일이 존재하지 않으면 기본 설정(library_name=JavaLibrary, max_days=7)을 
 *        작성하여 저장하고, 존재하는 경우 Properties.load()로 불러와서 프로그램 타이틀에 적용.
 *   2. 파일 관리 및 디렉토리 자동 생성 (File):
 *      - "data" 디렉토리가 없으면 mkdir()로 생성.
 *   3. 도서 마스터 데이터 인덱스 관리 (RandomAccessFile):
 *      - 도서 인덱스 파일("data/books.dat")은 고정 크기 레코드로 설계:
 *        * 책 ID (int, 4바이트) + 대출상태 (char, 2바이트: 'O' 대출가능, 'X' 대출중) = 총 6바이트 고정 크기.
 *      - 프로그램 시작 시 책 ID 1, 2, 3번에 대해 각각 'O'(대출가능) 상태로 3개 레코드(총 18바이트)를 파일에 미리 채워둠.
 *      - 대출이 발생하면 해당 책 ID 위치로 seek( (ID - 1) * 6 ) 이동 후 상태값을 'X'로 덮어쓰기. 반납 시 'O'로 변경.
 *   4. 대출 장부 누적 기록 (문자 스트림 및 Scanner):
 *      - 대출 처리 성공 시, "data/rentals.txt" 파일에 "[책ID],[대출자명],[대출일]" 형식의 한 줄을 BufferedWriter로 이어쓰기(append).
 *      - 장부 조회 시 Scanner를 사용하여 파일을 읽고 각 토큰을 쉼표 기준으로 추출하여 가독성 있게 콘솔 출력.
 *   5. 데이터 백업 기능 (바이트 스트림):
 *      - 텍스트 장부 파일("data/rentals.txt")을 FileInputStream/FileOutputStream을 사용하여 
 *        "data/rentals_backup.txt" 로 바이트 단위로 복사.
 */
public class MiniProjectGuide_New {
}
