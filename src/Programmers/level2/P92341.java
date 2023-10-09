package Programmers.level2;


import java.util.*;

class Solution92341 {
    public int[] solution(int[] fees, String[] records) {
        //차번호와 시간 해시맵

        HashMap<String, Integer> carMap = new HashMap<>();
        //차번호와 요금 해시맵 -> 차량번호 순으로 출력위해서 TreeMap -> RB트리 알고리즘이 적용-> 자동정렬
        Map<String, Integer> feeMap = new TreeMap<>();

        for (String str : records) {
            String[] slot = str.split(" ");
            int time = getMinute(slot[0]); //시간 (분으로 )
            String carNum = slot[1];//차량번호
            String InOut = slot[2]; //입,출 정보

            if (InOut.equals("IN")) {
                carMap.put(carNum, time);
            }
            if (InOut.equals("OUT")) {
                //첫 입출하는 차라면?
                if (!feeMap.containsKey(carNum)) {
                    feeMap.put(carNum, time - carMap.get(carNum));
                } else {
                    //이미 한번 입출 한 내역이 있으면
                    //기존 저장된 요금에 더 과금해야해
                    feeMap.put(carNum, feeMap.get(carNum) + time - carMap.get(carNum));
                }
                //입출 끝나면 car 해시맵에서 지워
                carMap.remove(carNum);
            }
        }

        System.out.println("carMap = " + carMap);
        //주차장이 비어있지 않다면?
        if (!carMap.isEmpty()) {
            for (String strCar : carMap.keySet()) {
                Integer cost = feeMap.get(strCar);
                if (cost == null) {
                    cost = 0;
                }
                feeMap.put(strCar, cost + (23 * 60 + 59) - carMap.get(strCar)); //23시59분에 출차했다고 가정한다.
            }
        }
        System.out.println("feeMap = " + feeMap);
        int[] answer = new int[feeMap.size()];
        int idx = 0;
        for (Integer c : feeMap.values()) {
            int basicTime = fees[0];
            int basicCharge = fees[1];
            int unitTime = fees[2];
            int unitCharge = fees[3];

            // 요금 = 기본요금 + ((min-기본시간) / 단위시간) * 단위요금
            if(basicTime >= c){
                //기본요금 부과
                answer[idx] = basicCharge;
            }else{
                answer[idx] = (int)(basicCharge + Math.ceil((double) (c - basicTime) / unitTime) * unitCharge);
            }
            idx++;
        }
        return answer;

    }

    private static int getMinute(String s) {
        String[] time = s.split(":");
        int t = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);

        return t;
    }
}
public class P92341 {
    public static void main(String[] args) {
        Solution92341 sol = new Solution92341();
        int[] fees = {120, 0, 60, 591};
        String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
        System.out.println(Arrays.toString(sol.solution(fees, records)));
    }
}
