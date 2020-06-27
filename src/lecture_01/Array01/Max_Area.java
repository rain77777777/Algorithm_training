package lecture_01.Array01;

import java.util.Scanner;

/**
 * 盛最多水的容器
 * leetcode : https://leetcode-cn.com/problems/container-with-most-water/
 * <p>
 * solution:
 * 1.暴力:两层循环，外循环为左边界，内循环为右边界，并将计算出的area值通过中间变量记录，有比它大的便update，O(n^2)
 * 2.双指针:选取左右两个边界值分别为left和right，找到比
 * <p>
 * sample:1 8 6 2 5 4 8 3 7
 */
public class Max_Area {
    public static void main(String[] args) {
        //  动态输入数组长度
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n]; //用来存放input值
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        //  暴力解法
        _violence(arr);

        //  双指针法
        _doublePoint(arr);
    }

    //  暴力解法
    public static void _violence(int[] arr) {
        System.out.println("this is _violence");
        int max_area = 0;
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                max_area = Math.max(max_area, (j - i) * (arr[i] > arr[j] ? arr[j] : arr[i]));
            }
        }
        System.out.println(max_area);
    }

    //  双指针法
    public static void _doublePoint(int[] arr) {
        System.out.println("this is _doublePoint");
        int max_area = 0;
        for (int left = 0, right = arr.length - 1; left < right; ) {
            max_area = Math.max(max_area, (arr[left] > arr[right] ? arr[right--] : arr[left++]) * (right - left + 1));
        }
        System.out.println(max_area);
    }
}
