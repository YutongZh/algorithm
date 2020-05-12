package sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        for (int end = arr.length - 1; end > 0; end --){   //固定一个范围
            boolean flag = false;
            for (int i = 0; i < end; i ++){  //在这个范围内进行比较
                if (arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,1,3,2};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
