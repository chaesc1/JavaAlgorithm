package Inflearn.exhaustiveSearch;

import java.util.*;
// m 개의 원소를 선택하여 순서를 고려하여 배열하여 2차원 리스트로 반환
public class ex3 {
    List<List<Integer>> res;
    void dfs(int[] arr, int m, List<Integer> curr, boolean[] visited) {

        // base case
        if (curr.size() == m) {
            res.add(new ArrayList<>(curr));
        }
        for(int i = 0; i < arr.length; i++) {
            // 내가 선택한 것은 선택하면 안되니까
            /*if (!curr.contains(arr[i])) { // O(N) 만큼 들어 -> visited 배열 추가해서 시간복잡도 낮춰.
                curr.add(arr[i]);
                res.addAll(dfs(arr,m,curr,visited));
                curr.remove(curr.size()-1);
            }*/
            if (!visited[i]) {
                curr.add(arr[i]);
                visited[i] = true; // 체크
                dfs(arr,m,curr,visited); // 재귀 넣고
                visited[i] = false; // 체크 풀고
                curr.remove(curr.size()-1); // 마지막 수 제거 해주고
            }
        }
    }
    public List<List<Integer>> permute(int[] arr, int m) {
        res = new ArrayList<>(); // 전역변수 한번 초기화 해주는게 좋아
        dfs(arr, m, new ArrayList<>(),new boolean[arr.length]);
        return res;
    }
    public static void main(String[] args) {
        ex3 e = new ex3();
        System.out.println(e.permute(new int[]{1,2,3,4}, 2));
    }
}
