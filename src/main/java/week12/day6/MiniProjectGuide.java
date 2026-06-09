package week12.day6;

/**
 * [종합 미니 프로젝트 가이드] Week 12 Day 6
 * 「 3계층 아키텍처 기반의 네트워크 성적 관리 DB 시스템 」
 * 
 * [미션]
 *   Week 12에서 배운 네트워크 프로그래밍(TCP 소켓 통신, HTTP API 요청), 데이터 교환 표준(JSON 데이터 파싱),
 *   데이터베이스 연동(JDBC 기초), 그리고 아키텍처 설계(3계층 구조 분리)를 모두 아우르는
 *   종합 네트워크 성적 관리 서버 및 클라이언트 시스템을 구현합니다.
 * 
 * [활용 개념 — Day별 대응]
 *   - Day 1 (소켓 통신 - 서버):
 *       ServerSocket을 활용해 특정 포트(예: 8080)에서 요청을 대기하고, 
 *       클라이언트 접속 시 소켓 스트림을 통해 메시지를 주고받는 서버 Presentation Layer를 구축합니다.
 *   - Day 2 (HTTP 통신):
 *       비즈니스 로직(Service Layer)에서 성적 정보를 조회하거나 등록할 때, 
 *       학생을 격려하는 랜덤 격언을 외부 무료 HTTP API(예: https://api.adviceslip.com/advice )로 
 *       HttpClient/HttpURLConnection을 이용해 호출 및 수집합니다. (실패 시 기본 문구로 폴백)
 *   - Day 3 (JSON 파싱):
 *       네트워크 전송 효율과 기종 간 데이터 호환을 위해, 학생 성적 데이터를 
 *       JSON 문자열 포맷(`{"name":"홍길동","score":95}`)으로 변환(마샬링) 및 수집 파싱(언마샬링)하여 소켓으로 통신합니다.
 *   - Day 4 (JDBC 기초):
 *       가상의 메모리 저장소가 아닌 JDBC 표준 Connection을 맺고 DB에 성적 테이블을 생성하여 
 *       데이터를 영속적으로 입력/조회하는 `JdbcScoreRepository`를 구현합니다.
 *       (H2 드라이버 부재 시 Memory 저장소로 자동 폴백하여 컴파일 및 실행 안정성 확보)
 *   - Day 5 (아키텍처 계층 분리):
 *       단일 책임을 위해 시스템을 Presentation(Socket Handler), Service(Business Logic & API Call), 
 *       Repository(JDBC DB Access) 계층으로 명확하게 나누어 통제합니다.
 * 
 * [상세 요구사항 및 클래스 설계]
 *   1. Domain 및 DTO 모델:
 *      - Score 클래스: String name, int score 필드 보유.
 *      - JSON 직렬화/역직렬화: 외부 라이브러리 의존성을 없애기 위해 표준 String 가공(indexOf, substring) 또는 
 *        표준 JSON 헬퍼를 소스 내에 자체 구현하여 JSON 문자열과 Score 객체 간의 변환을 제공합니다.
 *   2. Repository Layer (데이터베이스 계층):
 *      - ScoreRepository 인터페이스: void save(Score score) / List<Score> findAll()
 *      - JdbcScoreRepository 구현체: 
 *        * JDBC API 표준을 통해 H2 DB 인메모리 커넥션을 맺고 `scores` 테이블 생성 및 CRUD 실행.
 *        * 드라이버 로드 실패 시 경고를 출력하고 메모리 리스트에 저장하는 안정적 Fallback 메커니즘 포함.
 *   3. Service Layer (비즈니스 로직 계층):
 *      - ScoreService 클래스: 
 *        * 등록 시 유효성 검사(점수는 0~100점 사이) 수행.
 *        * 학생 목록을 조회하여 평균 점수를 계산하고 합격 여부 판단.
 *        * 외부 HTTP API 연동을 담당하는 메서드를 내장하여, JSON으로 넘어온 오늘의 격언(Advice)을 파싱해 제공.
 *   4. Presentation Layer (소켓 통신 및 실행 영역):
 *      - Presentation 컨트롤러 역할을 수행하는 소켓 서버 실행.
 *      - 클라이언트로부터 "ADD:[JSON문자열]" 또는 "LIST" 명령을 소켓 스트림으로 받아 알맞은 Service 메서드를 호출하고 
 *        결과(JSON 또는 안내 텍스트)를 클라이언트 소켓 스트림에 회신.
 *      - 소켓 통신을 통해 서버에 성적을 전송하고 결과를 수신하는 간단한 클라이언트 클래스(SocketClient) 포함.
 */
public class MiniProjectGuide {
}
