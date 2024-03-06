package zjs.sort;

public class ChaRu {
    private static void chaRu(int[] arry) {
        for (int i = 1; i < arry.length; i++) {
            int num = arry[i];
            int j = i - 1;
            while (j > 0 && arry[j] > num) {
                arry[i] = arry[j];
                j--;
            }
            arry[j + 1] = num;
        }
    }

    public static void main(String[] args) {
        int[] arry = new int[]{1, 3, 5, 2, 7, 4, 9, 10};
        chaRu(arry);
        for (int i = 0; i < arry.length; i++) {
            System.out.println(arry[i]);
        }
    }
}
