package lecture_01.Array01;

import java.util.Scanner;

/**
 * 旋转数组
 * leetcode：https://leetcode-cn.com/problems/rotate-array/
 * solution:
 * 1.暴力法:2个循环，来将数组中需要旋转的元素逐个向后移动，但时间复杂度为O(n^2)，过于复杂
 * 2.额外开辟数组：将原数组中的元素，直接放到新数组中正确的位置，如1放到索引为4的位置上，规则是（i + k）% nums.length
 * 3.原地反转数组：移动k个元素到数组开头，相当于是先反转一次原数组，然后将原数组分成左右两部分（以k位置切开），再分别进行反转即可
 * sample:
 * input:
 * [1,2,3,4,5,6,7] 和 k = 3
 * output:
 * [5,6,7,1,2,3,4]
 */
public class Rotate_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // 1.暴力法
        //_violence(nums, k);

        // 2.开辟新数组
        // _newArray(nums, k);

        // 3.原地反转数组
        _rotate(nums, k);
    }

    // 1.暴力法
    public static void _violence(int[] nums, int k) {
        System.out.println("_violence");
        int temp = 0;
        for (int i = 0; i < k; i++) {
            temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
        for (int x : nums) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    // 2.开辟新数组
    public static void _newArray(int[] nums, int k) {
        System.out.println("_newArray");
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 3.原地反转数组
    public static void _rotate(int[] nums, int k) {
        k = k % nums.length;// 目的是为了防止索引越界，如数组元素为1，k=1时，右边_reverse(nums, k, nums.length - 1)成了(nums,k=1,nums.length-1 = 0),nums[1] = nums[0]
        _reverse(nums, 0, nums.length - 1);
        _reverse(nums, 0, k - 1);
        _reverse(nums, k, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void _reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }


}
