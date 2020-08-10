package lecture_01.Stack01;

import java.util.Scanner;
import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈.
 * leetcode:https://leetcode-cn.com/problems/min-stack/
 * solution:
 * sample:
 * input:
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * output:
 * [[],[-2],[0],[-3],[],[],[],[]]
 */
public class Min_Stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack();
        stack.push(n);
        int x = 0 ;
        if(!stack.empty()){
           x=  stack.pop();
        }
        System.out.println(x);

    }
}
