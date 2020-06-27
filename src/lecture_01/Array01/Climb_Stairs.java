package lecture_01.Array01;

import java.util.Scanner;

/**
 * 爬楼梯
 * leetcode:https://leetcode.com/problems/climbing-stairs/
 * solution:
 * 1.暴力法（斐波那契数列）
 * 2.
 */
public class Climb_Stairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //1.暴力法
        int sum = 0;
        if (n <= 0) {
            System.out.println("please input a positive number");
        } else {
            //sum = _violence(n);
            //sum = _fibonacci(n);
            sum = _fibonacci_Optimize(n);
            System.out.println(sum);
        }


    }

    //1.暴力法(当input为45时，就无法再进行下去了)
    public static int _violence(int n) {
        int sum = 0;
        if (1 == n || 2 == n) {
            return n;
        }
        if (n > 2) {
            sum = _violence(n - 2) + _violence(n - 1);
        }
        return sum;
    }

    //2.改进版（动态规划）
    public static int _fibonacci(int n) {
        // 不加 n<=1这个判断，当n=1时，会引起后面dp[2]索引越界
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];//这里定义n+1是便于理解，索引 1 与 真正的第一个值对应
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
        /* 这里数组定义为n，相对应所有值全部前移一位，即dp[0]对应第一个数，dp[1]对应第二个数，想要求 n=3 ，即求 数组dp[2]便是最终结果值
        if( n <= 2){
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 3; i <= n; i++){
            dp[i-1] = dp[i-2]+dp[i-3];
        }
        return dp[n-1];*/
    }

    //3.改进优化版（使用2个变量）
    public static int _fibonacci_Optimize(int n) {
        if (n <= 2) {
            return n;
        }
        int num1 = 1;
        int num2 = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = num1 + num2;
            num1 = num2;
            num2 = sum;
        }
        return sum;
    }
}
