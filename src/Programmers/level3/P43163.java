package Programmers.level3;


class Solution43163 {
    boolean[] visited;
    static int answer = 0;
    public int solution(String begin, String target, String[] words) {

        visited = new boolean[words.length];

        dfs(begin,target,words,0);
        System.out.println(answer);
        return answer;
    }

    public void dfs(String begin, String target, String[] words, int cnt) {
        //target 과 begin의 단어가 같아 질때 종료
        if(begin.equals(target)) {
            answer = cnt;
        }
        for (int i = 0; i < words.length; i++) {
            //이미 방문했다면?
            if(visited[i]){
                continue;
            }
            int check = 0; //다른 단어 갯수 체크
            for (int j = 0; j < begin.length(); j++) {
                if(begin.charAt(j) != words[i].charAt(j)) {
                    check++;
                }
            }
            if(check == 1){
                visited[i] = true;
                dfs(words[i],target,words,cnt+1);
                visited[i] = false;
            }

        }
    }
}
public class P43163 {
    public static void main(String[] args) {
        Solution43163 s = new Solution43163();
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        s.solution(begin,target,words);
    }
}
