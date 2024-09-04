import java.io.BufferedReader;
import java.util.*;

public class Solution {

    // 사람을 표현하는 클래스
    static class Person {
        int x, y;

        public Person(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // 특정 문과의 거리를 계산하는 메서드
        public int getDistanceTo(Door door) {
            return Math.abs(x - door.x) + Math.abs(y - door.y);
        }
    }

    // 문을 표현하는 클래스
    static class Door {
        int x, y;
        int time;

        public Door(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int N; // 지도 크기
    static int minTime; // 최소 시간을 저장하는 변수
    static int[][] map;
    static List<Person> people;
    static List<Door> doors;
    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력

        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N]; 
            people = new ArrayList<>();
            doors = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        people.add(new Person(i, j));
                    } else if (map[i][j] > 1) {
                        doors.add(new Door(i, j, map[i][j]));
                    }
                }
            }

            minTime = Integer.MAX_VALUE;
            int[] selectedDoors = new int[people.size()]; // 각 사람이 선택할 문 정보를 저장할 배열
            dfs(selectedDoors, 0); // DFS를 통해 문 선택 조합을 생성하고 최소 시간 계산
            sb.append("#").append(tc).append(" ").append(minTime).append("\n"); // 결과 저장
        }
        System.out.println(sb.toString()); // 최종 결과 출력
    }

    // DFS를 사용하여 각 사람이 어느 문으로 이동할지 결정
    private static void dfs(int[] selectedDoors, int personIdx) {
        if (personIdx == people.size()) {
            List<Integer> door1Times = new ArrayList<>(); // 1번 문으로 가는 사람들의 도착 시간 리스트
            List<Integer> door2Times = new ArrayList<>(); // 2번 문으로 가는 사람들의 도착 시간 리스트

            for (int i = 0; i < selectedDoors.length; i++) {
                if (selectedDoors[i] == 0) {
                    door1Times.add(people.get(i).getDistanceTo(doors.get(0))); // 사람과 1번 문의 거리 계산하여 리스트에 추가
                } else {
                    door2Times.add(people.get(i).getDistanceTo(doors.get(1))); // 사람과 2번 문의 거리 계산하여 리스트에 추가
                }
            }

            // 각 문을 통해 내려가는 데 걸리는 시간을 계산하고 두 문 중 더 오래 걸린 시간을 선택
            int time = Math.max(calculateDoorTime(door1Times, doors.get(0).time), calculateDoorTime(door2Times, doors.get(1).time));
            // 최소 시간 갱신
            minTime = Math.min(minTime, time);
            return;
        }

        // 현재 사람을 1번 문으로 보냄
        selectedDoors[personIdx] = 0;
        dfs(selectedDoors, personIdx + 1); // 다음 사람 선택

        // 현재 사람을 2번 문으로 보냄
        selectedDoors[personIdx] = 1;
        dfs(selectedDoors, personIdx + 1); // 다음 사람 선택
    }

    // 특정 문의 계단을 내려가는 데 걸리는 총 시간을 계산하는 메서드
    private static int calculateDoorTime(List<Integer> arrivalTimes, int time) {
        // 각 사람의 도착 시간을 오름차순으로 정렬
        Collections.sort(arrivalTimes);

        // 계단을 내려가는 동안의 대기열을 관리할 큐 초기화
        Queue<Integer> queue = new LinkedList<>();

        // 최종적으로 걸린 시간을 저장할 변수
        int totalTime = 0;

        // 모든 도착 시간을 순회
        for (int arrival : arrivalTimes) {
            // 현재 시간 이전에 있는 모든 계단을 내려간 사람들을 큐에서 제거
            while (!queue.isEmpty() && queue.peek() <= arrival) {
                queue.poll();
            }

            // 계단 위에 있는 사람이 3명 이내인 경우
            if (queue.size() < 3) {
                // 현재 사람을 계단에 추가, 도착 시간 + 내려가는 데 필요한 시간
                queue.add(arrival + time);
            } else {
                // 계단이 가득 차 있는 경우
                // 가장 빨리 내려가는 사람의 다음 가능 시간을 가져와서
                int nextFreeTime = queue.poll();
                // 현재 사람의 계단 이용 시간을 추가
                queue.add(nextFreeTime + time);
            }
        }

        // 총 걸린 시간을 계산
        // 대기열이 비워질 때까지 순회하며 마지막 남은 가장 큰 시간을 totalTime에 저장
        while (!queue.isEmpty()) {
            totalTime = queue.poll();
        }

        // 마지막에 모든 사람이 계단을 내려가는 데 걸린 총 시간을 반환, 1은 보정값
        return totalTime + 1;
    }
}