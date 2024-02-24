package zjs.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HeapUtil {

    /**
     * @param list  list表示的堆
     * @param size  列表长度
     * @param index 需要维护元素的下标
     * @return void
     * @author: ZhegnJinSong
     * @description: 堆化 heapify(大顶堆)
     * @date: 2024/2/20 9:07
     */
    public static void big_heapify(List<Integer> list, int size, int index) {
        int max_index = index;
        int curr_left_index = 2 * index + 1;
        int curr_right_index = 2 * index + 2;
        if (curr_left_index < size && list.get(max_index) < list.get(curr_left_index)) {
            max_index = curr_left_index;
        }
        if (curr_right_index < size && list.get(max_index) < list.get(curr_right_index)) {
            max_index = curr_right_index;
        }
        if (max_index != index) {
            Collections.swap(list, index, max_index);
            big_heapify(list, size, max_index);
        }
    }

    /**
     * @param list 数据list
     * @return
     * @author: ZhegnJinSong
     * @description: 建堆并且利用堆排序（大顶堆，降序）
     * @date: 2024/2/20 9:32
     */
    public static void sort_big_heap(List<Integer> list) {
        /**建堆**/
        //从堆上最后一个叶子节点的父节点开始堆化，由右到左，由下至上，上浮式建堆（最大的值往上走）
        for (int i = (list.size() - 1) / 2; i >= 0; i--) {
            big_heapify(list, list.size(), i);
        }
        /**利用大顶堆降序**/
        for (int i = list.size() - 1; i >= 0; i--) {
            Collections.swap(list, i, 0);
            big_heapify(list, i, 0);
        }

    }

    /**
     * @param list 数组表示的堆
     * @param val  需要入堆的元素
     * @return void
     * @author: ZhegnJinSong
     * @description: 元素入堆，按照完全二叉树的规则从上至下，从左至右依次添加到二叉树
     * @date: 2024/2/21 9:12
     */
    public static void push(List<Integer> list, Integer val) {
        list.add(val);
        siftUp(list, list.size()-1);
    }

    /**
     * @param list  表示的堆
     * @param i 需要堆化的下标
     * @return viud
     * @author: ZhegnJinSong
     * @description: 元素自下而上的堆化
     * @date: 2024/2/21 9:32
     */
    public static void siftUp(List<Integer> list, int i) {
        while (true) {
            int parent = (i - 1) / 2;
            if (list.get(parent) >= list.get(i)) break;
            Collections.swap(list, i, parent);
            i = parent;
        }
    }

    /**
     * @param list  list表示的堆
     * @param size  列表长度
     * @param index 需要维护元素的下标
     * @return void
     * @author: ZhegnJinSong
     * @description: 堆化 heapify(小顶堆)
     * @date: 2024/2/20 9:07
     */
    public static void small_heapify(List<Integer> list, int size, int index) {
        int min_index = index;
        int index_left_index = index * 2 + 1;
        int index_right_index = index * 2 + 2;
        if (index_left_index < size && list.get(min_index) > list.get(index_left_index)) {
            min_index = index_left_index;
        }
        if (index_right_index < size && list.get(min_index) > list.get(index_right_index)) {
            min_index = index_right_index;
        }
        if (min_index != index) {
            Collections.swap(list, index, min_index);
            small_heapify(list, size, min_index);
        }
    }

    /**
     * @param list 数据list
     * @return
     * @author: ZhegnJinSong
     * @description: 建堆并且利用堆排序（小顶堆，升序）
     * @date: 2024/2/20 9:32
     */

    public static void sort_small_heap(List<Integer> list) {
        /** 建堆**/
        for (int i = (list.size() - 1) / 2; i >= 0; i--) {
            small_heapify(list, list.size(), i);
        }
        /**利用大顶堆升序**/
        for (int i = list.size() - 1; i >= 0; i--) {
            Collections.swap(list, 0, i);
            small_heapify(list, i, 0);
        }
    }

    public static void main(String[] args) {
        //大顶堆，降序
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 7, 8, 9, 12, 56, 23, 25));
        sort_big_heap(list);
        for (Integer curr : list) {
            System.out.println(curr);
        }
        System.out.println("...................   ");
        //小顶堆，升序
        sort_small_heap(list);
        for (Integer curr : list) {
            System.out.println(curr);
        }
        System.out.println("...................   ");
        List<Integer> list1=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            push(list1,i);
        }
        for (Integer curr : list1) {
            System.out.println(curr);
        }
    }

}
