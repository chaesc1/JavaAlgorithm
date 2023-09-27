//우선순위 큐 -> FIFO 구조
//데이터가 들어온 순서대로 데이터가 나가는 것이 아니라
//우선순위를 먼저 결정하고 / 우선순위가 높은 데이터가 먼저 나가는 자료구조이다.
//PriorityQueue는 Heap을 이용하여 구현하는 것이 일반적이다.

//Priority Queue 선언
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class DS_PriorityQueue {
    public static void main(String[] args) {
        //낮은 숫자가 우선순위인 int 형 우선순위 큐 선언
        PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();
        //높은 숫자가 우선 순위인 int형 우선순위 큐 선언
        PriorityQueue<Integer> getPriorityQueueHighest = new PriorityQueue<>();

        //add,offer
        //1, 15, 8, 21, 25, 18, 10 값 추가
        priorityQueueLowest.add(1); //Collections클래스에서 가져온 메서드
        priorityQueueLowest.add(15);
        priorityQueueLowest.offer(10);//Queue 클래스에서 가져오는 메서드
        priorityQueueLowest.add(21);
        priorityQueueLowest.add(25);
        priorityQueueLowest.offer(18);
        priorityQueueLowest.add(8);
        System.out.println(priorityQueueLowest);

        //값 삭제 - poll, remove, clear
        priorityQueueLowest.poll();//우선순위가 가장 높은 값을 제거
        System.out.println(priorityQueueLowest);

        priorityQueueLowest.remove();//우선순위가 가장 높은 값을 제거
        System.out.println(priorityQueueLowest);
        priorityQueueLowest.remove(1);//remove(index)는 index순위에 해당하는 값을 제거함
        System.out.println(priorityQueueLowest);

        //Size()
        System.out.println(priorityQueueLowest.size());

        //출력
        Iterator iterator = priorityQueueLowest.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next()+" ");

    }
}
