package lecture_01.Linkedlist01;

import java.util.Scanner;

/**
 * 返回倒数第 k 个节点
 * leetcode:https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 * solution:
 * 1.双指针法：定义2个指针都指向头结点，先让一个指针移动k个位置，然后与另一个指针相距k个位置，然后两个指针同步后移，当后面指针移动到链表末尾时候，前面的指针就是倒数第k个结点
 * sample:
 * input: 1->2->3->4->5 和 k = 2
 * output: 4
 */
public class Kth_To_Last {
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
        int out = 0;
        if (k <= n) {
            out = _kthToLast(head, k);
            System.out.println(out);
        } else {
            System.out.println("所输入的值：" + k + " 已经超出了链表的长度了，需要重新输入");
        }
    }

    public static int _kthToLast(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        //int x = 0;
        for(int i = 0;i<k;i++){ // 先让后面指针向后移动k个位置
            fast = fast.next;
        }
        /*while (x < k && fast.next != null) {
            fast = fast.next;
        }*/
        while (fast != null) { // 当后面的指针下一个为空时候，就停止，返回前面那个指针即为所要答案
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
