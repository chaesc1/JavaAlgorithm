package Programmers.level2;

import java.util.ArrayList;

class Solution84512{
    String[] words= {"A","E","I","O","U"};;
    ArrayList<String> list;
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();

        dfs("",0);
//        System.out.println("list = " + list);
        for(int i=0; i<list.size(); i++){
            if(word.equals(list.get(i))){
                answer = i;
                break;
            }
        }
        return answer;
    }

    private void dfs(String s, int length) {
        list.add(s);
        if(length == 5) return;
        for (int i = 0; i < 5; i++) {
            dfs(s+words[i],length+1);
        }
    }
}
public class P84512 {
    public static void main(String[] args) {
        Solution84512 sol = new Solution84512();
        String word = "AAAE";
        System.out.println("sol.solution(word) = " + sol.solution(word));
    }
}
