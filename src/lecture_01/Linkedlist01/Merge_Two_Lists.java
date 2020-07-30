package lecture_01.Linkedlist01;

import java.util.Scanner;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * leetcode:https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * solution:
 * 1.双指针法：分别为两个链表定义2个扫描指针，通过比较两个指针的val大小来确定顺序，添加到新的head后面，最后谁有剩余，直接copy至新链表结尾即可
 * sample:
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Merge_Two_Lists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] nums1 = new int[n1];
        int[] nums2 = new int[n2];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = sc.nextInt();
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = sc.nextInt();
        }

        ListNode l1 = new ListNode();
        ListNode head1 = l1.createLinkedList(nums1);
        l1.printLinkedList(head1);
        ListNode head2 = l1.createLinkedList(nums2);
        l1.printLinkedList(head2);
        ListNode pre = _doublePoints(head1, head2);
        l1.printLinkedList(pre);
    }

    //1.双指针法
    public static ListNode _doublePoints(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(0);
        ListNode pre = prehead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1; // 判断l1和l2哪个为空，l1为空，直接将l2剩余链表接到新链表尾部
        return prehead.next; // 此时pre节点已经不在头部了
    }
}
