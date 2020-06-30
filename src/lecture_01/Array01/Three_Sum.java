package lecture_01.Array01;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 三数之和
 * leetcode:https://leetcode-cn.com/problems/3sum/
 * solution:
 * 1.暴力法：循环3次遍历来枚举
 * 2.双指针法：左右下标向中间推进
 * 3.hash表法：
 * <p>
 * sample:
 * input:[-1, 0, 1, 2, -1, -4]
 * output:
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Three_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = sc.nextInt();
        }

        //1.暴力法
        _violence(nums);

        //2.sort+双指针法：降低复杂度变成twoSum
        _doublePoint(nums);

        //3。sort+双指针法优化版
        _doublePoint_Optimize(nums);

    }

    //1.暴力法 O(n^3)
    public static void _violence(int[] nums) {
        System.out.println("this is a method of _violence");
        Set<List<Integer>> set = new LinkedHashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        list = Arrays.asList(nums[i], nums[j], nums[k]);
                        //list.add(nums[i]);
                        //list.add(nums[j]);
                        //list.add(nums[k]);
                        set.add(list);
                    }
                }
            }
        }
        for (List<Integer> x : set) {
            System.out.println(x);
        }
    }

    //2.sort+双指针法：降低复杂度变成twoSum
    public static void _doublePoint(int[] nums) {
        System.out.println("this is a method of _doublePoint");
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        //  nums.length - 2 是因为固定了一个位置，所以循环次数减去1，长度为6，而索引应该是0-5，此时索引应该是0-4，所以是长度减去2
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                if (nums[i] + nums[j] == 0 - nums[k]) {
                    list = Arrays.asList(nums[i], nums[j], nums[k]);
                    res.add(list);
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                } else if (nums[i] + nums[j] < 0 - nums[k]) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (nums[i] + nums[j] > 0 - nums[k]) {
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        for (List<Integer> x : res) {
            System.out.println(x);
        }
    }

    //3.优化版
    public static void _doublePoint_Optimize(int[] nums) {
        System.out.println("this is a method of _doublePoint_Optimize");
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length; k++) {
            if (k == 0 || k > 0 && nums[k] != nums[k - 1]) { //  无需再判断当k=0时，nums[k]是不是大于0，后面直接利用等式来判断是否成立，当k>0时，必须满足下一个值与当前值不相等，跳过重复值
                int i = k + 1, j = nums.length - 1, sum = 0 - nums[k];
                while (i < j) {
                    if (nums[i] + nums[j] == sum) {
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                        while (i < j && nums[i] == nums[i + 1]) i++;// 跳过重复的数字
                        while (i < j && nums[j] == nums[j - 1]) j--;// 跳过重复的数字
                        i++;
                        j--;
                    } else if (nums[i] + nums[j] < sum) {
                        //while (i < j && nums[i] == nums[++i]) ;这里不需要重复再判断是否与前一个数相等，因为当前数已经不能让3个数成立，前面一个数即使与他相等也是不成立，还是可以筛选掉的
                        i++;
                    } else {
                        //while (i < j && nums[j] == nums[--j]) ;
                        j--;
                    }
                }
            }
        }
        for (List<Integer> x : res) {
            System.out.println(x);
        }
    }
}
