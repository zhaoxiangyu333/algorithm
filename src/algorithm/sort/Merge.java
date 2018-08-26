package algorithm.sort;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

/**
 * 归并排序
 */
public class Merge {
    static Comparable[] aux;

    /**
     * 相对应的排序算法
     *
     * @param a
     */
    public static void sort(Comparable[] a) {

    }

    /**
     * 原地归并方法
     *
     * @param a
     * @param low
     * @param mid
     * @param height
     */
    public static void merge(Comparable[] a, int low, int mid, int height) {
        int i = low;
        int j = mid + 1;

        for (int k = low; k <= height; k++) {
            aux[k] = a[k];
        }

        for (int k = low; k <= height; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > height) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[i++];
            }
        }
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
