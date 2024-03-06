package zjs.search;

public class Search {

    /**
     * @param arry 数组
     * @param val  查找目标
     * @return int
     * @author: ZhegnJinSong
     * @description：二分查找法在数组里查找值
     * @date: 2024/2/26 17:40
     */
    public static int binarySearch(int[] arry, int val) {
        if (arry == null || arry.length == 0) {
            return -1;
        }
        int i = 0, j = arry.length - 1;
        while (i <= j) {
            int target = (i + j) / 2;
            if (val == arry[target]) {
                return target;
            } else if (val < target) {
                j = target-1;
            } else {
                i = target+1;
            }
        }
        return -1;
    }

    /**
     * @param arry 数组
     * @param val  要查找的元素
     * @return
     * @author: ZhegnJinSong
     * @description: 多路查找法查找插入点，如果有相同元素则返回最左边的元素,算是把指针玩明白了
     * @date: 2024/2/27 9:30
     */
    public static int binarySearchInsertSimple(int[] arry, int val) {
        if (arry == null || arry.length == 0) {
            return -1;
        }
        int i = 0, j = arry.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (val < arry[m]) {
                j = m - 1;
            } else if (val > arry[m]) {
                i = m + 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int arry[] = new int[]{1, 2, 4, 5, 6, 6, 6, 7, 8, 90};
        int arry1[] = new int[]{0,0,1, 2, 4, 5, 6, 6, 6, 7, 8, 90};
        int i = binarySearch(arry, 90);
        int i1 = binarySearchInsertSimple(arry, 6);
        System.out.println(i);
    }
}
