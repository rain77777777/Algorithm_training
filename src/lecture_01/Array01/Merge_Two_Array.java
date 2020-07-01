package lecture_01.Array01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 合并两个有序数组
 * leetcode:https://leetcode-cn.com/problems/merge-sorted-array/
 * solution:
 * 1.开辟新数组，遍历旧数组并经过比较放入新数组中
 * 2.直接放到第一个数组中（本题中第一个数组足够大）
 * sample:
 * input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * output: [1,2,2,3,5,6]
 */
public class Merge_Two_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // 第一个数组的长度
        int n = sc.nextInt(); // 第二个数组的长度
        int[] nums1 = new int[m];
        int[] nums2 = new int[n];
        for (int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }

        // 1.开辟新数组
        _newArray(nums1, m, nums2, n);
        // 2.直接放入第一个数组中
        _putFirst(nums1, m, nums2, n);
    }

    // 1.开辟新数组
    public static void _newArray(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];// 这里是认为第一个数组和第二个数组都是刚好装下m,n的，nums1并不是可以装下（m+n），在该题限定条件下不可使用，面试视情况可以用
        int i = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index_nums1 = 0;
        int index_nums2 = 0;
        while ((index_nums1 < m) && (index_nums2 < n)) {
            if (nums1[index_nums1] < nums2[index_nums2]) {
                res[i++] = nums1[index_nums1++];
            } else {
                res[i++] = nums2[index_nums2++];
            }
        }
        // 第一次错误：索引错误，由于sample中第一个数组已经遍历完毕了，剩下的只需要把nums2剩余的放到新数组中即可
        // 但此时不能直接用k=index，因为新数组已经放了4个数字了，应该从索引下标 4 开始放入nums2剩余数字，
        // 此时如果直接用k = index_nums2（此时k为1）开始的话，会覆盖掉前面部分已经放好的数字(res[1] 在之前已经放入了2，所以此时会被覆盖为5)
        /*if (index_nums1 < m) {
            for (int k = index_nums1; k < m; k++) {
                res[k] = nums1[k];
            }
        }
        if (index_nums2 < n) {
            for (int k = index_nums2; k < n; k++) {
                res[k] = nums2[k];
            }
        }*/

        if (index_nums1 < m) {
            System.arraycopy(nums1, index_nums1, res, index_nums1 + index_nums2, m + n - index_nums1 - index_nums2);
        }
        if (index_nums2 < n) {
            System.arraycopy(nums2, index_nums2, res, index_nums1 + index_nums2, m + n - index_nums1 - index_nums2);
        }

        for (int j = 0; j < res.length; j++) {
            System.out.print(res[j] + " ");
        }
    }

    // 2.直接放入第一个数组中
    public static void _putFirst(int[] nums1, int m, int[] nums2, int n) {

    }
}
