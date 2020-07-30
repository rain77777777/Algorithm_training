package lecture_01.Linkedlist01;

import java.util.Scanner;

/**
 * 两两交换链表中的节点
 * leetcode:https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * solution:
 * 1.递归法:
 * 主要考虑三要素：（1）终止条件：当前无节点或者只有当前这一个节点，即head == null或者head.next == null
 * （2）返回值是什么：每2个节点交换之后的子链表
 * （3）每个重复的小单元的功能：两个节点相互交换
 * 2.非递归法:
 *  sample:
 *  输入：1->2->3->4
 *  输出：2->1->4->3
 */
public class Swap_Pairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        ListNode l1 = new ListNode();
        ListNode head = l1.createLinkedList(nums);
        l1.printLinkedList(head);
        //ListNode pre = _recursion_swapPairs(head);
        ListNode pre = _nonrecursion_swapPairs(head);
        l1.printLinkedList(pre);
    }

    //1.递归法
    public static ListNode _recursion_swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //写法一
        /*ListNode first = head;
        ListNode second = head.next;

        first.next = _recursion_swapPairs(second.next);
        second.next = first;
        return second;*/

        //写法二
        ListNode next = head.next;  // 下一个节点为当前链表头节点的下一个节点
        head.next = _recursion_swapPairs(next.next);    // 递归找出当前节点的下一个节点，直到最后一个节点
        next.next = head;   // 最后一个节点与它前一个节点进行交换
        return next;    //  并且返回它交换后的前一个位置的节点
    }

    //2.非递归法
    public static ListNode _nonrecursion_swapPairs(ListNode head) {
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode cur = tmp;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next = second.next;
            cur.next = second;
            cur.next.next = first;
            cur = cur.next.next;
        }
        return tmp.next;

    }
}
