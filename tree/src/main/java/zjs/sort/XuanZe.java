package zjs.sort;

public class XuanZe {

    private static void xuanZe(int[] arry) {
        for (int i = arry.length - 1; i > 0; i--) {
            int temp = 0;
            for (int j = 1; j <= i; j++) {
                if (arry[j] > arry[temp]) {
                    temp = j;
                }
            }
            int val = arry[i];
            arry[i] = arry[temp];
            arry[temp] = val;
        }
    }

    public static void main(String[] args) {
        int[] arry = new int[]{1, 3, 5, 2, 7, 4, 9, 10};
        xuanZe(arry);
        for (int i = 0; i < arry.length; i++) {
              System.out.println(arry[i]);
        }
    }
}
