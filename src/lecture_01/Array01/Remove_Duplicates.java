package lecture_01.Array01;

import java.util.Scanner;

/**
 * 删除排序数组中的重复项
 * leetcode:https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * solution:
 * 1.双指针法：利用一快一慢指针在原数组上进行遍历，通过两个指针来判断所遍历的数字是否相同，相同就让右指针往下走，不相同就让右指针的值直接放到左指针的位置的下一个位置
 * sample:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 无需要考虑数组中超出新长度后面的元素
 */
public class Remove_Duplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        // 1.双指针法
        _doublePoint(nums);

        // 2.优化版
        _doublePoint_Optimize(nums);
    }

    // 1.双指针法
    public static void _doublePoint(int[] nums) {
        System.out.println("_doublePoint");
        int fast = 1;
        int slow = 0;
//        int count = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[slow + 1] = nums[fast];
                slow++;
//                count++;
            }
            fast++;
        }

        // 写法2
        /*while (fast < nums.length) {
            if(nums[fast] == nums[slow]){
                fast++;
            }else{
                slow++;
                if (fast - slow > 0) {
                    nums[slow] = nums[fast];
                }
                fast++;
            }
        }*/

//        for (int i = 0; i <=count; i++) {
//            System.out.print(nums[i] + " ");
//        }
    }

    // 2.优化版
    // 由于每次判断nums[fast] != nums[slow]时，都会将nums[slow]赋值给nums[fast+1]，即自己复制一份数据给自己所在的位置上
    // 这里应该加一个优化，让fast和slow之间的距离大于1才可以赋值 即 fast - slow > 1
    public static void _doublePoint_Optimize(int[] nums) {
        System.out.println("_doublePoint_Optimize");
        int fast = 1;
        int slow = 0;
//        int count =0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                if (fast - slow > 1) {
                    nums[slow + 1] = nums[fast];
                }
                slow++;
            }
//            count++;
            fast++;
        }
//         for (int i = 0; i <count; i++) {
//             System.out.print(nums[i] + " ");
//         }
        // return slow+1;
    }

}
