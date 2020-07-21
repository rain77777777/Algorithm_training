package lecture_01.Linkedlist01;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 反转单链表
 * leetcode：https://leetcode-cn.com/problems/reverse-linked-list/
 * soulution：
 * 1.迭代法：将当前节点的next指针指向前一个节点，因为是单链表，所以需要额外一个节点tmp来存储下一个节点，然后利用pre节点来存储上一个节点，
 * 最后返回pre节点，因为此时pre节点是原链表最后一个节点，同时也是新链表的第一个节点
 * 2.递归法：
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */

public class Reverse_List {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        ListNode l1 = new ListNode();
        ListNode head = l1.createLinkedList(nums);
        l1.printLinkedList(head);
        ListNode pre = _reverseList(head);
        l1.printLinkedList(pre);
    }

    //1.迭代法
    public static ListNode _reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    //2.递归法
}
