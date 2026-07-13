package Inflearn.exhaustiveSearch;

public class P1 {
    public int solution(int balance, int[][] countries) {
        boolean[] visited = new boolean[countries.length];
        return dfs(balance, 0, visited, countries);
    }
    public int dfs(int balance, int count, boolean[] visited, int[][] countries) {
        int max = count;

        for(int i=0; i<countries.length; i++) {
            if(visited[i]) continue;

            int cost = countries[i][0];
            int required = countries[i][1];

            if (balance >= required) {
                visited[i] = true;
                /*dfs(balance-cost, count+1, visited, countries)*/
                max = Math.max(max, dfs(balance-cost, count+1, visited, countries));
                visited[i] = false;
            }
        }

        return max;
    }
    //여행자의 현재 통장 잔고 balance와,
    // 각 나라별 "입국 필요 잔고" 및 "여행 경비"가 담긴 2차원 배열 countries
    public static void main(String[] args) {
        P1 p1 = new P1();
        System.out.println(p1.solution(600, new int[][]{
                {70,80},
                {100,550},
                {350,400}
        }));
    }
}
