import java.util.*;

class Solution {
    static class Mineral {
        int dia;
        int iron;
        int stone;
        
        public Mineral(int dia,int iron,int stone) {
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
        
        public String toString() {
            return this.dia + " " + this.iron + " " + this.stone;
        }
    }
    
    static int min = Integer.MAX_VALUE;
    static int[][] board;
    static ArrayList<Mineral> list;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        board = new int[][] {
            {1,1,1},
            {5,1,1},
            {25,5,1}
        };
        list = new ArrayList<>();
        int total = Arrays.stream(picks).sum();
        
        for(int i=0; i<minerals.length; i+=5) {
            if(total == 0) break;
            int dia = 0;
            int iron = 0;
            int stone = 0;
            
            for(int j=i; j<i+5; j++) {
                if(j == minerals.length) break;
                
                String mineral = minerals[j];
                int index = mineral.equals("iron") ? 1 : mineral.equals("stone") ? 2 : 0;
                dia += board[0][index];
                iron += board[1][index];
                stone += board[2][index];
            }
            list.add(new Mineral(dia,iron,stone));
            total--;
        }
        Collections.sort(list,((o1,o2) -> (o2.stone - o1.stone)));
        for(Mineral mineral : list) {
            int dia = mineral.dia;
            int iron = mineral.iron;
            int stone = mineral.stone;
            
            if (picks[0] > 0) {
                answer += dia;
                picks[0]--;
                continue;
            }
            if (picks[1] > 0) {
                answer += iron;
                picks[1]--;
                continue;
            }
            if (picks[2] > 0) {
                answer += stone;
                picks[2]--;
                continue;
            }
            
        }
        return answer;
    }
}