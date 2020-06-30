package lecture_01.Array01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 三数之和与target最接近
 * leetcode:https://leetcode.com/problems/3sum-closest/
 * solution:
 * 1.暴力法：循环3次遍历来枚举
 * 2.双指针法：左右下标向中间推进，求得三数之和与target相减得绝对值得最小值
 * <p>
 * sample:
 * input:nums = [-1,2,1,-4], target = 1
 * output: 2
 */

public class Three_Sum_Closest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        _doublePoint(nums, target);
    }

    public static void _doublePoint(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[nums.length - 1];//原数组是无序的，随意取三个数加起来作为一个临时数值
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) { //定义双指针时候，这里的循环一定要确保不要超出范围，最后一个值已经被赋予给了变量，所以不需要遍历
            /*if (k == 0 || k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }*/
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];//这个一定要在while循环中，不然i,j都是固定值
                if (sum > target) { // 当三数之和大于target，则说明需要再一个再小一点的数，所以右指针需要左移
                    j--;
                } else {// 当三数之和小于target，则说明需要再一个再大一点的数，所以左指针需要左移
                    i++;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)) { //通过对 sum和res减去target的绝对值 进行比较，值小的，离target更近，所以将这个sum数赋值给res
                    res = sum;
                }
            }
        }
        System.out.println("the number is :" + res);
    }
}
