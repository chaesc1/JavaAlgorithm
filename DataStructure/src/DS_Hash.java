//해시 자료구조
//key, value 쌍으로 이뤄진 자료구조
//key값을 해시함수를 통해 -> 해시코드를 리턴
//저장공간의 Size 로 나눠 Index를 정해 Value 를 저장한다.
//인덱스를 구하는 과정에서 똑같은 공간을 가리켜
//연결된 저장형태를 나타내기도 한다.
//key 와 index 가 충돌하는 경우를 해시충돌이라고 한다.
//최악의 경우 O(N)의 시간복잡도를 띈다.


import java.util.HashMap;
import java.util.Map;

//HashMap으로 구현
public class DS_Hash {
    public static void main(String[] args) {
        HashMap<String,String> map1 = new HashMap<String,String>();//HashMap생성
        HashMap<String,String> map2 = new HashMap<>();//new에서 타입 파라미터 생략가능
        HashMap<String,String> map3 = new HashMap<>(map1);//map1의 모든 값을 가진 HashMap생성
        HashMap<String,String> map4 = new HashMap<>(10);//초기 용량(capacity)지정
        HashMap<String,String> map5 = new HashMap<>(10, 0.7f);//초기 capacity,load factor지정
        HashMap<String,String> map6 = new HashMap<String,String>(){{//초기값 지정
            put("a","b");
        }};

        HashMap<String,Integer> map = new HashMap<>(); //파라미터 생략 가능
        map.put("classic",800);
        map.put("classic",400);//key가 같다면 새로 입력되는 값으로 초기화된다.
        map.put("Pop",1000);

        System.out.println(map);
        System.out.println(map.get("Pop"));//key = Pop 인 값을 출력한다.

        //entrySet() 활용 -> 데이터의 양이 많을 경우 더 성능이 좋음.
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("[Key]:" + entry.getKey() + " [Value]:" + entry.getValue());
        }

        //KeySet() 활용
        for(String i : map.keySet()){ //저장된 key값 확인
            System.out.println("[Key]:" + i + " [Value]:" + map.get(i));
        }
    }
}
