package algorithm.sort;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

/**
 * 堆排序
 */
public class MaxPQ<Key extends Comparable<Key>> {
    // 基于堆得完全二叉树
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax(){
        Key max = pq[1];
        exch(1,N--);
        pq[N-1] = null;
        sink(1);
        return max;
    }

    /**
     * 辅助函数比较元素大小
     *
     * @param i
     * @param j
     * @return
     */
    public boolean less(int i, int j) {
        return pq[i].compareTo(pq[2]) < 0;
    }

    /**
     * 辅助函数交换位置
     *
     * @param a
     * @param i
     * @param j
     */
    public void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 辅助函数交换位置2
     *
     * @param i
     * @param j
     */
    public void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    /**
     * 上浮算法
     *
     * @param k
     */
    public void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 下沉算法
     *
     * @param k
     */
    public void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                exch(k, j);
                k = j;
            }
        }
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

    public static void main(String[] args) {
    }
}
