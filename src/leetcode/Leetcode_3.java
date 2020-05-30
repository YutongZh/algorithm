package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长无重复子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 解决思路：滑动窗口
 * 无重复 字眼  用map
 * 子串  字眼 用滑动窗口
 */
public class Leetcode_3 {

    public static int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() <= 0) {
            return 0;
        }

        //定义一个map存储每个字符上一次出现的位置
        Map<Character, Integer> map = new HashMap<>();

        //长度的最大值
        int max = 0;
        //无重复字符最长时候的最左指针
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                //如果重复元素在left左边，则保持left不变，如果在右边或相等，则取上一次重复元素的下一个字符
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            //每次和历史最大长度比较取最大值
            max = Math.max(max, i - left + 1);
            map.put(s.charAt(i), i);
        }
        return max;
    }

    public static void main(String[] args) {
        int pwwkew = lengthOfLongestSubstring("pwwkew");
        System.out.println(pwwkew);
    }
}
