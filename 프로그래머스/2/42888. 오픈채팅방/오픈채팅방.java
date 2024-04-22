import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String,String> msg = new HashMap<>();
        msg.put("Enter","님이 들어왔습니다.");
        msg.put("Leave","님이 나갔습니다.");
        
        HashMap<String,String> idMap = new HashMap<>();
        for(String r : record) {
            String[] line = r.split(" ");
            if(line.length == 3) {
                //Enter, Change 인 경우
                idMap.put(line[1],line[2]); // UID , name 삽입
            }
        }
        
        ArrayList<String> list = new ArrayList<>();
        // System.out.println(idMap);
        
        for(String r : record) {
            String[] line = r.split(" ");
            if(msg.containsKey(line[0])) {
                list.add(idMap.get(line[1]) + msg.get(line[0]));
            }
        }
        String[] answer = new String[list.size()-1];
        answer = list.toArray(answer);
        // System.out.println(list);
        return answer;
    }
}