package zjs.sort;

public class MaoPao {
    private static void maoPao(int[] arry) {
        for (int i = arry.length - 1; i > 0; i--) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (arry[j] > arry[j + 1]) {
                    int tem = arry[j + 1];
                    arry[j + 1] = arry[j];
                    arry[j] = tem;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arry = new int[]{1, 3, 5, 2, 7, 4, 9, 10};
        maoPao(arry);
        for (int i = 0; i < arry.length; i++) {
            System.out.println(arry[i]);
        }
    }
}
