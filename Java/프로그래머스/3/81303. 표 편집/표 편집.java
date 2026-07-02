import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> deleted = new Stack<>();
        // up, down 배열 
        int[] up = new int[n+2];
        int[] down = new int[n+2];
        
        for(int i=0; i<n+2; i++) {
            up[i] = i-1;
            down[i] = i+1;
        }
        
        k++; // 현재위치 
        
        // 주어진 명령어 배열 하나씩 처리
        for(String c : cmd) {
            if(c.startsWith("C")) {
                deleted.push(k);
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                k = n < down[k] ? up[k] : down[k];
            }
            // 가장 최근에 삭제된 행을 복원
            else if(c.startsWith("Z")) {
                int restore = deleted.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            }
            else {
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
                for(int i=0; i<x; i++) {
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        }
        
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        
        for(int i : deleted) {
            answer[i-1] = 'X';
        }
        return new String(answer);
    }
}