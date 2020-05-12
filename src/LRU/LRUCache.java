package LRU;

class Solution {


    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode temp = head.next;
        head.next = null;
        temp.next = head;
        return reverseList(temp);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        Solution solution = new Solution();
        ListNode result = solution.reverseList(listNode);
        System.out.println(result);
    }
}