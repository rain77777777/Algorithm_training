package lecture_01.Array01;

import java.util.Scanner;

/**
 * 移动零
 * leetcode:https://leetcode-cn.com/problems/move-zeroes/
 * <p>
 * solution:
 * 1.loop,遍历整个数组时统计0的个数，将非0元素放到前面，最后剩余位置放入0，要两个loop
 * 2.重新开一个新数组，并设置两个指针（头部指针i，尾部指针j），遍历旧数组，将非0元素放入新数组头部，将0放入新数组尾部。（空间换时间）
 * 3.直接在内存操作，使用一个额外的变量j来记录非零元素应该放的位置，即：j这个位置存放的是下一个非零元素。
 * sample:
 * input:[0,1,0,3,12]
 * output:[1,3,12,0,0]
 */

public class Move_Zeros {
    public static void main(String[] args) {
        //动态输入数组长度和元素
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = sc.nextInt();
        }

        //1.两次loop
        _violence(arr);

        //2.双指针法
        _doublePoint(arr);

        //3.index法
        _indexExchange(arr);

    }

    //1.两次loop(类似于冒泡法)
    public static void _violence(int[] arr) {
        System.out.println("this is a method of _violence");
        //定义一个索引，在该索引处放非零元素
        int index = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] != 0) {
                arr[index++] = arr[i];
            }
        }
        //index的最终值即为所有非零元素中的最后一位，从该index到最后全部置为零
        for (int j = index; j < arr.length; ++j) {
            arr[j] = 0;
        }
        for (int x : arr) {
            System.out.print(x);
            System.out.print(' ');
        }
        System.out.println();

    }

    //  2.双指针法
    public static void _doublePoint(int[] arr) {
        System.out.println("this is a method of _doublePoint");
        //  定义一个新的数组
        int[] arr_new = new int[arr.length];
        //  新数组的左指针
        int left = 0;
        //  新数组右指针
        int right = arr.length - 1;
        //  遍历旧的数组，将非零元素放到新数组的左边，零元素放到新数组的右边
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == 0) {
                arr_new[right--] = arr[i];
            } else {
                arr_new[left++] = arr[i];
            }
        }
        for (int i = 0; i < arr_new.length; ++i) {
            System.out.print(arr_new[i] + " ");
        }
        System.out.println();
    }

    //3.index法（原数组操作）
    public static void _indexExchange(int[] arr) {
        System.out.println("this is a method of _indexExchange");
        //  索引记录非零元素放在什么位置

        //  solution 1
        /*int index = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] != 0) {
                arr[index] = arr[i];
                if (i != index) {
                    arr[i] = 0;
                }
                index++;
            }
        }
        for (int x : arr) {
            System.out.print(x + " ");
        }*/

        //  solution 2
        int index = 0;
        for (int x : arr) {
            if (x != 0) {
                arr[index++] = x;
            }
        }
        while (index < arr.length) {
            arr[index++] = 0;
        }
        for (int x : arr) {
            System.out.print(x + " ");
        }

    }

}
