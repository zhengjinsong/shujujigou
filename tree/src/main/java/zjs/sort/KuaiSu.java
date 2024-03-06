package zjs.sort;

public class KuaiSu {
    public static void swap(int[] arry, int i, int j) {
        int temp = arry[i];
        arry[i] = arry[j];
        arry[j] = temp;
    }

    public static int partition(int[] arry, int left, int right) {
        int i = left, j = right;
        while (i < j) {
            while (i < j && arry[j] >= arry[left]) {
                j--;
            }
            while (i < j && arry[i] <= arry[left]) {
                i++;
            }
            swap(arry, i, j);
        }
        swap(arry, i, left);
        return i;
    }

    private static void quickSort(int[] arry, int left, int right) {
        if (left >= right) return;
        int mid = partition(arry, left, right);
        quickSort(arry, left, mid - 1);
        quickSort(arry, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] arry = new int[]{1, 3, 5, 2, 7, 4, 9, 10};
        quickSort(arry, 0, arry.length - 1);
        for (int i = 0; i < arry.length; i++) {
            System.out.println(arry[i]);
        }
    }
}
