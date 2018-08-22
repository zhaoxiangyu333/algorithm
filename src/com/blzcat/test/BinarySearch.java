package com.blzcat.test;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Arrays;

/**
 * 二分法查找，要求数组需有序
 */
public class BinarySearch {
    public static int rank(int key, int[] a) {
        //定义最大最小范围
        int low = 0;
        int hight = a.length - 1;
        while (low <= hight) {
            int mid = (low + hight) / 2;
            if (key < a[mid]) {
                hight = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // 被查找数的参考数组-白名单
        int[] whitelist = In.readInts(args[0]);
        // 排序
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            int keyIn = StdIn.readInt();
            int result = rank(keyIn, whitelist);
            if (result == -1) {
                StdOut.println("未找到输入值：" + keyIn);
            } else {
                System.out.println("在第" + result + "位置找到");
            }
        }
    }
}
