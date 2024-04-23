import java.util.*;
import java.util.stream.Stream;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,ArrayList<int[]>> genreMap = new HashMap<>();
        //재생횟수를 map
        HashMap<String,Integer> playMap = new HashMap<>();
        for(int i=0; i<genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            if(!genreMap.containsKey(genre)) {
                // map -> nullPointer 조심
                genreMap.put(genre,new ArrayList<>());
                playMap.put(genre,0);
            }
            genreMap.get(genre).add(new int[] {i,play});
            playMap.put(genre,playMap.get(genre) + play);
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        //1.재생횟수가 많은 장르로 정렬
        Stream<Map.Entry<String,Integer>> sortedGenre = playMap.entrySet().stream()
                                                            .sorted((o1, o2) -> Integer.compare(o2.getValue(),o1.getValue()));
        //2.장르 내에서 정렬 후 2개 꺼내
        sortedGenre.forEach(entry -> {
            Stream<int[]> sortedSongs = genreMap.get(entry.getKey()).stream()
                                                .sorted((o1,o2) -> Integer.compare(o2[1],o1[1]))
                                                .limit(2);
            sortedSongs.forEach(song -> answer.add(song[0]));
        });
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}