import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String,HashSet<String>> reportedMap = new HashMap<>();
        HashMap<String,Integer> count = new HashMap<>();
        
        for(String r : report) {
            String[] str = r.split(" ");
            String userName = str[0]; //신고한사람
            String reportName = str[1]; //신고당한 사람
            
            if(!reportedMap.containsKey(reportName)) {
                reportedMap.put(reportName,new HashSet<>());
            }
            reportedMap.get(reportName).add(userName);
        }
        
        //reportedMap 순회
        for(HashMap.Entry<String,HashSet<String>> entry : reportedMap.entrySet()) {
            // System.out.println(entry.getValue());
            if(entry.getValue().size() >= k) {
                for(String name : entry.getValue()) {
                    count.put(name, count.getOrDefault(name,0)+1);
                }
            }
        }
        
        // System.out.println(count); 
        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++) {
            answer[i] = count.getOrDefault(id_list[i],0);
        }
        return answer;
    }
}