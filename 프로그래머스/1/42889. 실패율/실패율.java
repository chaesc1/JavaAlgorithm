import java.util.*;
//실패율은 다음과 같이 정의한다.
// 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
class Solution {
    public int[] solution(int N, int[] stages) {
        // 스테이지별 도전자
        int[] challenger = new int[N+2];
        for(int i=0; i<stages.length; i++) {
            challenger[stages[i]] += 1;
        }
        
        //스테이지별 실패율 계산
        HashMap<Integer, Double> map = new HashMap<>();
        double total = stages.length;
        for(int i=1; i<=N; i++) {
            if(challenger[i] == 0) {
                map.put(i,0.0);
            } else {
                map.put(i,challenger[i] / total);
                total -= challenger[i];
            }
        } 
        
        
        //실패율이 높은 순서대로 정렬
        return map.entrySet().stream().sorted((o1,o2) -> Double.compare(o2.getValue(),o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}