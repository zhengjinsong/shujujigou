package zjs.heap;

import java.util.*;

public class Top_k {
    /**
     * @param list 数组
     * @param num  取top前几个值
     * @return
     * @author: ZhegnJinSong
     * @description: TODO
     * @date: 2024/2/21 10:40
     */
    public static Queue<Integer> top_k(List<Integer> list, int num) {
        //优先级队列升序（从队列头到尾升序）
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < num; i++) {
            queue.offer(list.get(i));
        }
        for (int i = num; i < list.size(); i++) {
            if (list.get(i) > queue.peek()) {
                queue.poll();
                queue.offer(list.get(i));
            }
        }
        return queue;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 4, 6, 1, 9, 2, 23, 45, 32));
        Queue<Integer> integers = top_k(list, 3);
        for (int i = 0; i < 3; i++) {
            System.out.println(integers.poll());
        }


    }

}
