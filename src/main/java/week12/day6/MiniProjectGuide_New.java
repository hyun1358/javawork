package week12.day6;

/**
 * [종합 미니 프로젝트 가이드 - 신규] Week 12 Day 6
 * 「 멀티스레드 TCP 채팅 서버 및 HTTP API 연동 챗봇 시스템 」
 * 
 * [목적]
 *   Week 12에서 배운 네트워크 프로그래밍 핵심 개념(TCP 소켓, 멀티스레드 소켓 서버, UDP 브로드캐스팅, 
 *   HttpURLConnection/HttpClient 외부 API 요청)을 모두 활용하여 고도화된 정보 제공 채팅 엔진을 작성합니다.
 * 
 * [활용 개념 — Day별 대응]
 *   - Day 1 (네트워크 기초):
 *       InetAddress를 활용해 서버 시작 시 호스트 이름과 내부 IP 주소를 확인하고 로그에 기록.
 *   - Day 2 (TCP 소켓):
 *       ServerSocket과 Socket을 이용해 일대다 통신 환경의 기본 네트워크 뼈대 구축.
 *   - Day 3 (UDP 소켓):
 *       TCP 채팅과 별개로, 관리자가 전체 클라이언트에게 긴급 공지사항을 송신하기 위해 
 *       DatagramSocket과 DatagramPacket을 사용한 UDP 비연결성 브로드캐스팅 채널 구축.
 *   - Day 4 (멀티스레드 소켓 서버):
 *       다중 접속자를 동시에 처리하기 위해 ExecutorService 스레드 풀을 구성하여 
 *       클라이언트 접속 수락 시마다 스레드를 할당해 독립적인 1:1 메시지 핸들러(ClientHandler) 작동.
 *   - Day 5 (HTTP 클라이언트 & JSON 파싱):
 *       채팅방 내에서 사용자가 "/weather" 또는 "/fact" 등의 특정 명령어를 입력할 경우, 
 *       서버가 외부 무료 HTTP 웹 API에 HttpURLConnection으로 연동 요청을 보내 응답 문자열을 수집한 뒤 
 *       원하는 데이터만 파싱하여 클라이언트에게 회신하는 챗봇 기능 적용.
 * 
 * [상세 요구사항]
 *   1. 메인 서버 아키텍처:
 *      - ServerSocket을 포트 5001에서 실행.
 *      - ExecutorService 스레드 풀(크기 10)을 생성하여 다중 접속 관리.
 *      - 접속한 모든 클라이언트의 출력 스트림을 목록(List<PrintWriter>)으로 보관하여 브로드캐스팅 전송.
 *   2. 클라이언트 핸들러 (ClientHandler):
 *      - Runnable 구현체로, 개별 소켓의 인풋 스트림을 계속 읽어들이는 루프 수행.
 *      - 일반 대화는 모든 접속자에게 브로드캐스트.
 *      - 사용자가 "/fact" 입력 시 HTTP 호출 수행:
 *        * 외부 API(예: https://catfact.ninja/fact - 고양이 지식 제공 무료 API)에 HTTP GET 요청을 보냄.
 *        * 수신한 문자열(JSON 포맷)에서 간단한 스트링 파싱기법을 써서 "fact" 부분만 추출하여 해당 클라이언트에게 전송.
 *   3. UDP 긴급 공지 시스템:
 *      - 서버 구동 시 별도 스레드로 UDP 수신 소켓(포트 5002)을 열어 대기.
 *      - 외부 관리자 툴에서 5002 포트로 UDP 패킷을 전송하면, 서버가 이를 감지하여 현재 TCP 채팅방에 참여 중인 
 *        모든 사용자에게 "[긴급 공지]" 말머리로 강제 전송.
 *   4. 가상 클라이언트 구동:
 *      - 테스트가 가능하도록 TCP 클라이언트 역할을 하는 실행 클래스를 메인에 포함하거나 가이드 형태로 정의.
 */
public class MiniProjectGuide_New {
}
