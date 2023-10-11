package Programmers.level2;

import java.util.Arrays;
import java.util.HashMap;

class SolutionP42888{
    public String[] solution(String[] record) {
        //uid - name
        HashMap<String,String> idMap = new HashMap<>();

        //record 를 split
        //첫번째 index = command / Enter,Leave,Change
        //두번째 uid
        //세번째 name
        int cnt = 0; //change 형식
        for (int i = 0; i < record.length; i++) {
            String[] info = record[i].split(" ");

            if(info[0].equals("Leave")){
                continue;
            }else if(info[0].equals("Enter")){
                idMap.put(info[1],info[2]);
            }else{//change 일경우
                idMap.put(info[1],info[2]);
                cnt++;
            }
        }
        System.out.println(idMap);
        String[] answer = new String[record.length-cnt];
        int idx = 0;
        //출력형식에 맞게 출력해주면 된다.
        for (int i = 0; i < record.length; i++) {
            String[] info = record[i].split(" ");

            if(info[0].equals("Leave")){
                answer[idx++] = idMap.get(info[1])+"님이 나갔습니다";
            }else if(info[0].equals("Enter")){
                answer[idx++] = idMap.get(info[1])+"님이 들어왔습니다.";
            }
        }
        return answer;
    }
}
public class P42888 {
    public static void main(String[] args) {
        SolutionP42888 sol = new SolutionP42888();
        String[] record = {"Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"};

        System.out.println("Arrays.toString(sol.solution(record)) = " + Arrays.toString(sol.solution(record)));
    }
}
