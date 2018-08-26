package algorithm.sort;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class Quick {
    /**
     * 相对应的排序算法
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        // 打乱数组a，消除对输入的依赖
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int height) {
        if (height < low) {
            return;
        }
        int j = partition(a, low, height);
        sort(a, low, j - 1);
        sort(a, j + 1, height);
    }

    public static int partition(Comparable[] a, int low, int height) {
        int i = low;
        int j = height + 1;
        Comparable v = a[low];
        while (true) {
            while (less(a[++i], v)) {
                if (i == height) {
                    break;
                }
            }

            while (less(v, a[--j])) {
                if (j == low) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            exch(a, i, j);
        }
        exch(a, low, j);
        return j;
    }

    /**
     * 辅助函数比较元素大小
     *
     * @param v
     * @param w
     * @return
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 辅助函数交换位置
     *
     * @param a
     * @param i
     * @param j
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 打印字符数组
     *
     * @param a
     */
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    /**
     * 判断数组是否有序
     *
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a) : "the array is not sorted";
        show(a);
    }
}
