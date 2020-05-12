package sort;

import java.util.Arrays;

/**
 *  荷兰国旗问题
 *
 *  eg：给定一个整数数组，给定一个值K，这个值在原数组中一定存在，要求把数组中小于K的元素放到数组的左边，大于K的元素放到数组的右边，
 *  等于K的元素放到数组的中间，最终返回一个整数数组，其中只有两个值，分别是等于K的数组部分的左右两个下标值。
 *
 */
public class NetherlandsFlag {

    public static int[] partition(int[] arr, int L, int R, int num) {
        int less = L - 1;   //小于区域
        int more = R + 1;   //大于区域
        int cur = L;
        while (cur < more) {  //最大区域指针和两个指针相撞，则结束
            if (arr[cur] < num) {
                swap(arr, ++less, cur++);  //当前值和小于区域下一个数交换，并且移动到下一个位置
            } else if (arr[cur] > num) {
                swap(arr, --more, cur); //当前值和大于区域上一个值交换，这里注意是cur， 因为大于区域交换过去的数可能是小于或等于，需要待定，所以保持原地不动
            } else {
                cur ++;
            }
        }
        return new int[]{less + 1, more -1};
    }

    public static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,6,3,8,9,6,2,7};    //1, 2, 3,  6,6,   7,8,9
        int[] partition = partition(arr, 0, arr.length - 1, 6);
        for (int i : partition) {
            System.out.println(i);
        }
    }

}
