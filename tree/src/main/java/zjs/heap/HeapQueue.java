package zjs.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class HeapQueue {
    public  static  Queue<Integer> maxQueue = new PriorityQueue<>((a, b) -> b - a);

    public static void main(String[] args) {
        maxQueue.add(1);
        maxQueue.add(3);
        maxQueue.add(5);
        maxQueue.add(6);
        Integer peek = maxQueue.peek();
        System.out.println(peek);
        System.out.println(maxQueue.poll());
        System.out.println(maxQueue.poll());
        maxQueue.add(12);
    }
}
