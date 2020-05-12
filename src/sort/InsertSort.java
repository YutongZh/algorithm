package sort;

/**
 * 插入排序
 */
public class InsertSort {

    public static void insertSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        for (int i = 1; i < arr.length; i ++){ //从N-1里找个 和前面有序集合比较并插入
            for (int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,1,3,2};
        insertSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
