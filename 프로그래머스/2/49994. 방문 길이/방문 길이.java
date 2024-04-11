import java.util.*;
// 0,0 -> 5,5 로 바꿔서 음수 해결
class Solution {
    private static final HashMap<Character, int[] > location = new HashMap<>();
    
    private static void dxdy() {
        location.put('U',new int[] {0,1});
        location.put('D',new int[] {0,-1});
        location.put('R',new int[] {1,0});
        location.put('L',new int[] {-1,0});
    }
    
    public int solution(String dirs) {
        // 중복된 경로를 추려내려면?? x -> nx 정보를 Set 에 저장?
        HashSet<String> answer = new HashSet<>();
        int x = 5,y = 5; //초기 위치를 5,5로 초기화
        dxdy(); //벡터 설정하고
        
        for(int i=0; i < dirs.length(); i++) {
            int[] start = location.get(dirs.charAt(i));
            int nx = x + start[0];
            int ny = y + start[1];
            
            //좌표에서 벗어나면?
            if(!isValid(nx,ny)) {
                continue;
            }
            
            answer.add(x+""+y+""+nx+""+ny); //x -> y , nx -> ny 
            answer.add(nx+""+ny+""+x+""+y);
            
            x = nx;
            y = ny;
        }
        return answer.size() / 2;
    }
    
    private static boolean isValid(int nx,int ny) {
        return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
    }
}