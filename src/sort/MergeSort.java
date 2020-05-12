package sort;

/**
 *  归并排序
 */
public class MergeSort {

    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        processor (arr,0, arr.length-1);
    }

    private static void processor(int[] arr, int l, int r) {
        if (l == r){
            return;
        }

        int mid = (l + r) / 2;
        processor(arr, l, mid);  //左边排好序
        processor(arr, mid + 1, r);  //右边排好序
        merge(arr, l, r, mid);   //合并
    }

    private static void merge(int[] arr, int l, int r, int mid) {
        //申请一个临时数组
        int[] help = new int[r - l + 1];
        int i = 0;

        //定义两个指针
        int p1 = l;
        int p2 = mid + 1;

        //最小的放入临时数组，然后向后挪一位
        while (p1 <= mid && p2 <= r){
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        //p1未耗尽  P2耗尽 将P1剩下的挪到临时数组
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }

        while (p2 <= r){
            help[i++] = arr[p2++];
        }

        //拷贝回原数组
        for (i = 0; i < help.length; i++){
            arr[l + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,1,3,2};
        mergeSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
