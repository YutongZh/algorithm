package sort;

/**
 * 选择排序
 */
public class SelectSort {

    public static void selectSort(int[] arr){

        if (arr == null || arr.length <2){
            return;
        }

        for (int i = 0; i < arr.length; i++){
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j ++){
                minIdx = arr[j] < arr[minIdx] ? j : minIdx;
            }
            //交换元素
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,1,3,2};
        selectSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
