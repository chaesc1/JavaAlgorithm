package BOJ.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11725_dfs {
    public static void main(String[] args) {
        int stationCount = 5;
        int[][] trainInfo = {{1, 5, 2}, {2, 3, 1}};
        int[][] passengerInfo = {{1, 5}, {1, 3}, {2, 5}, {2, 4}, {2, 4}, {3, 5}, {4, 5}};

        int result = maxReservation(stationCount, trainInfo, passengerInfo);
        System.out.println("최대 수용 가능한 승객 수: " + result);
    }

    public static int maxReservation(int stationCount, int[][] trainInfo, int[][] passengerInfo) {
        Arrays.sort(passengerInfo, Comparator.comparingInt(a -> a[0])); // 승차역을 기준으로 손님 정보 정렬

        List<PriorityQueue<Integer>> trainSchedule = new ArrayList<>();
        for (int i = 0; i <= stationCount; i++) {
            trainSchedule.add(new PriorityQueue<>());
        }

        for (int[] train : trainInfo) {
            int start = train[0];
            int end = train[1];
            int capacity = train[2];

            for (int station = start; station <= end; station++) {
                while (!trainSchedule.get(station).isEmpty() && trainSchedule.get(station).peek() < start) {
                    trainSchedule.get(station).poll();
                }

                int passengersToAdd = capacity - trainSchedule.get(station).size(); // 추가로 탑승 가능한 승객 수 계산
                for (int i = 0; i < passengersToAdd && i < passengerInfo.length; i++) {
                    int[] passenger = passengerInfo[i];
                    if (passenger[0] <= station && station <= passenger[1]) {
                        trainSchedule.get(station).offer(passenger[1]);
                    }
                }
            }
        }

        int maxPassengers = 0;
        for (PriorityQueue<Integer> queue : trainSchedule) {
            maxPassengers += queue.size();
        }

        return maxPassengers;
    }

}
