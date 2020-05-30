package leetcode;

/**
 *  两数之和
 *
 *  给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 */
public class Leetcode_2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //定义哑结点
        ListNode pre = new ListNode(0);
        //新定义的一个链表
        ListNode cur = pre;
        //表示进位
        int carry = 0;

        while(l1 != null || l2 != null){

            //注意这里要用x，y替换 否则会空指针 比如【1，8】 【0】
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum  = x + y + carry;
            //表示进位
            carry = sum / 10;
            //表示实际应该存的值
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        //如果l1 和 l2 都走完，则处理进位
        if(carry == 1){
            cur.next = new ListNode(carry);
        }
        //注意要有始有终
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }
}
