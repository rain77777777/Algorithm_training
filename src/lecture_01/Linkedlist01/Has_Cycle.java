package lecture_01.Linkedlist01;

import java.util.Scanner;

/**
 * 环形链表
 * leetcode：https://leetcode-cn.com/problems/linked-list-cycle/
 * solution:
 * 1.双指针法（快慢指针）：定义2个指针，一个快指针和一个慢指针，每次慢指针走一步，快指针走两步，若有环的话，快指针最终会追上慢指针
 * sample:
 * input：head = [3,2,0,-4], pos = 1
 * output：true
 * explain：链表中有一个环，其尾部连接到第二个节点。
 */
public class Has_Cycle {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        ListNode l1 = new ListNode();
        ListNode head = l1.createLinkedList(nums);
        l1.printLinkedList(head);
        System.out.println(_doublePoint(head));*/
    }

    public static boolean _doublePoint(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return false;
    }
}
