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
    static int minTime;

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

            minTime = Integer.MAX_VALUE;
            int[] selectedDoors = new int[people.size()];
            dfs(selectedDoors, 0);

            sb.append("#").append(tc).append(" ").append(minTime).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int[] selectedDoors, int personIdx) {
        if (personIdx == people.size()) {
            List<Integer> door1Times = new ArrayList<>();
            List<Integer> door2Times = new ArrayList<>();

            for (int i = 0; i < selectedDoors.length; i++) {
                if (selectedDoors[i] == 0) {
                    door1Times.add(people.get(i).getDistanceTo(doors.get(0)));
                } else {
                    door2Times.add(people.get(i).getDistanceTo(doors.get(1)));
                }
            }

            int time = Math.max(calculateDoorTime(door1Times, doors.get(0).time), calculateDoorTime(door2Times, doors.get(1).time));
            minTime = Math.min(minTime, time);

            return;
        }

        selectedDoors[personIdx] = 0;
        dfs(selectedDoors, personIdx + 1);

        selectedDoors[personIdx] = 1;
        dfs(selectedDoors, personIdx + 1);
    }

    private static int calculateDoorTime(List<Integer> arrivalTimes, int time) {
        Collections.sort(arrivalTimes);
        Queue<Integer> queue = new LinkedList<>();
        int totalTime = 0;

        for (int arrival : arrivalTimes) {
            while (!queue.isEmpty() && queue.peek() <= arrival) {
                queue.poll();
            }
            if (queue.size() < 3) {
                queue.add(arrival + time);
            } else {
                int nextFreeTime = queue.poll();
                queue.add(nextFreeTime + time);
            }
        }

        while (!queue.isEmpty()) {
            totalTime = queue.poll();
        }

        return totalTime + 1;
    }
}