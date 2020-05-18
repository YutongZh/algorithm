package search;


/**
 *
 * 33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 *
 * 结题思路： 抠字眼   有序，查找， 时间复杂度log（n），必然二分
 * 如果比较中间的数和左右两端的数的大小，如果左边小，那么证明左边有序，否则右边有序。
 */
class BinarySearch {

    public static int search(int[] nums, int target) {

        if(nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            }

            //中间比左边大，左边有序 注意是小于等于，不然如果值是{2,1}会出问题。
            if(nums[start] <= nums[mid]) {
                //为什么选择nums[start] <=nums[mid]而不是nums[start]<nums[mid]
                //我觉得主要是因为除法是向下取整的，所以此处需要考虑在特殊情况下等号的位置
                //[start, mid)
                if(nums[mid] > target && nums[start] <= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                //注意这里的等号   （mid， end]
                if(nums[mid] < target && nums[end] >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = new  int[]{2,1};
        System.out.println(search(nums, 1));
    }
}
