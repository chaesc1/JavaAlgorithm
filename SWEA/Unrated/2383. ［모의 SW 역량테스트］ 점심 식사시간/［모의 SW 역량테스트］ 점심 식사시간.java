import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Person {
        int x, y;

        public Person(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getDistanceTo(Door door) {
            return Math.abs(x - door.x) + Math.abs(y - door.y);
        }
    }

    static class Door {
        int x, y;
        int time;

        public Door(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int N;
    static int[][] map;
    static List<Person> people;
    static List<Door> doors;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

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

            int result = solve();
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int solve() {
        int numPeople = people.size();
        int minTime = Integer.MAX_VALUE;

        // 모든 사람마다 두 문의 도착 시간을 계산
        int[][] timeToDoors = new int[numPeople][2];
        for (int i = 0; i < numPeople; i++) {
            Person person = people.get(i);
            for (int j = 0; j < 2; j++) {
                timeToDoors[i][j] = person.getDistanceTo(doors.get(j));
            }
        }

        // 모든 가능한 배치를 시뮬레이션하여 최소 시간을 계산
        for (int i = 0; i < (1 << numPeople); i++) {
            List<Integer> door1Times = new ArrayList<>();
            List<Integer> door2Times = new ArrayList<>();

            // 각 배치에 따른 도착 시간을 도출
            for (int j = 0; j < numPeople; j++) {
                if ((i & (1 << j)) == 0) {
                    door1Times.add(timeToDoors[j][0]);
                } else {
                    door2Times.add(timeToDoors[j][1]);
                }
            }
            minTime = Math.min(minTime, calculateTime(door1Times, doors.get(0).time, door2Times, doors.get(1).time));
        }

        return minTime+1;
    }

    // 각 문의 대기 시간에 대한 최종 시간을 계산
    private static int calculateTime(List<Integer> door1Times, int door1Time, List<Integer> door2Times, int door2Time) {
        Collections.sort(door1Times);
        Collections.sort(door2Times);

        int totalTime = 0;
        totalTime = Math.max(totalTime, calculateDoorTime(door1Times, door1Time));
        totalTime = Math.max(totalTime, calculateDoorTime(door2Times, door2Time));

        return totalTime;
    }

    // 한 문의 대기 시간 계산
    private static int calculateDoorTime(List<Integer> arrivalTimes, int stairTime) {
        int time = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int arrival : arrivalTimes) {
            while (!queue.isEmpty() && queue.peek() <= arrival) {
                queue.poll();
            }
            if (queue.size() < 3) {
                queue.add(arrival + stairTime);
            } else {
                int nextFreeTime = queue.poll();
                queue.add(nextFreeTime + stairTime);
            }
        }
        while (!queue.isEmpty()) {
            time = queue.poll();
        }

        return time;
    }
}