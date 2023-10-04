package Programmers.level3;

import java.util.*;

class SolutionP42579 {
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        HashMap<String,Integer> num = new HashMap<>(); //장르별 총 개수 저장
        HashMap<String,HashMap<Integer,Integer>> musicNum = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            if(!num.containsKey(genres[i])){ //장르에 해당된 key 값이 없다면!
                //index , 재생횟수 (play) 담는 해시
                HashMap<Integer,Integer> map = new HashMap<>();
                map.put(i,plays[i]);

                musicNum.put(genres[i],map);
                num.put(genres[i],plays[i]); //
            }else{
                //이미 값이 있다면..!
                musicNum.get(genres[i]).put(i,plays[i]);
                num.put(genres[i],num.get(genres[i])+plays[i]); //플레이 횟수를 누적해서 더함
            }
        }
        System.out.println(musicNum);
        List<String> Keyset = new ArrayList(num.keySet());
        Collections.sort(Keyset, (s1, s2) -> num.get(s2) - (num.get(s1))); //num : value 오름차순으로
//        System.out.println(Keyset);
        ArrayList<Integer> answer = new ArrayList<>();

        for(String key : Keyset){
            HashMap<Integer,Integer> map = musicNum.get(key);

            List<Integer> genre_key = new ArrayList(map.keySet());
            Collections.sort(genre_key, (s1,s2) -> map.get(s2) - (map.get(s1)));
//            System.out.println(genre_key.size());
//            System.out.println(map.get(genre_key.get(0)));
            answer.add(genre_key.get(0));
            if(genre_key.size()>1){
                answer.add(genre_key.get(1));
            }

        }
        return answer;
    }
}
public class P42579 {
    public static void main(String[] args) {
        SolutionP42579 sol = new SolutionP42579();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(sol.solution(genres,plays));

    }
}
