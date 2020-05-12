package sort;

/**
 *  快速排序
 *
 *  经典快排的
 */
public class QuickSort {

    public static void quickSort(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }

        int l = 0;
        int r = arr.length - 1;
        //经典排序
        quickSortClass(arr, l, r);
        //经典排序优化后的排序
        //quickSortFlag(arr, l, r);
    }

    /**
     * 经典快排
     */
    private static void quickSortClass(int[] arr, int l, int r) {
        if (l >= r){
            return;
        }
        int p = partion(arr, l, r);
        quickSortClass(arr, l, p - 1);
        quickSortClass(arr, p + 1, r);
    }

    /**
     * 荷兰国旗优化后的快排
     */
    private static void quickSortFlag(int[] arr, int l, int r) {
        if (l >= r){
            return;
        }

        //随机快排
        swap(arr, (int)Math.random() * (r - l + 1), r);
        int[] p = partionByFlag(arr, l, r);
        quickSortFlag(arr, l, p[0] - 1);
        quickSortFlag(arr, p[1] + 1, r);
    }

    /**
     * 经典快排partion
     */
    private static int partion(int[] arr, int l, int r){
        int num = arr[r];
        int cur = l;
        int less = l - 1;
        while(cur < r) {
            if (arr[cur] <= num) {
                swap(arr, ++less, cur++);
            } else {
                cur ++;
            }
        }
        swap(arr, less + 1, r);
        return less + 1;
    }

    /**
     * 用荷兰国旗算法优化后的快排
     */
    private static int[] partionByFlag (int[] arr, int l, int r) {
        int num = arr[r];
        int cur = l;
        int less = l - 1;
        int more = r + 1;
        while (cur < more){
            if (arr[cur] < num) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > num) {
                swap(arr, --more, cur);
            } else {
                cur ++;
            }
        }
        return new int[] {less + 1, more - 1};
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }




    public static void main(String[] args) {
        int[] arr = new int[]{4,5,1,3,2,1,2,5};
        quickSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
