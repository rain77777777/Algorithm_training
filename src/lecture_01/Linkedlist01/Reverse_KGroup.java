package lecture_01.Linkedlist01;

import java.util.Scanner;

/**
 * K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * leetcode:https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * solution:
 * 1.
 * sample:
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 */
public class Reverse_KGroup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        ListNode l1 = new ListNode();
        ListNode head = l1.createLinkedList(nums);
        l1.printLinkedList(head);
        ListNode pre = _recursion_reversse(head, k, n);
        l1.printLinkedList(pre);
    }

    public static ListNode _recursion_reversse(ListNode head, int k, int n) {
        return null;
    }
}
