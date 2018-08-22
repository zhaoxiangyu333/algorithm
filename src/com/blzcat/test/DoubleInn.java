package com.blzcat.test;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Dijkstra（迪杰斯特拉）双栈算数表达式求值
 */
public class DoubleInn {
    public static void main(String[] args) {
        // 运算符栈
        Stack<String> ops = new Stack<>();
        // 操作数栈
        Stack<Double> vals = new Stack<>();
        while (!StdIn.isEmpty()) {
            String inS = StdIn.readString();
            if (inS.equals("(")) {
                ops.push(inS);
            } else if (inS.equals("+")) {
                ops.push(inS);
            } else if (inS.equals("-")) {
                ops.push(inS);
            } else if (inS.equals("*")) {
                ops.push(inS);
            } else if (inS.equals("/")) {
                ops.push(inS);
            } else if (inS.equals("sqrt")) {
                ops.push(inS);
            } else if (inS.equals(")")) {
                // 弹出运算符和操作数，计算结果并压入栈
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) {
                    v = vals.pop() + v;
                } else if (op.equals("-")) {
                    v = vals.pop() - v;
                } else if (op.equals("*")) {
                    v = vals.pop() * v;
                } else if (op.equals("/")) {
                    v = vals.pop() / v;
                } else if (op.equals("sqrt")) {
                    v = Math.sqrt(v);
                }
                vals.push(v);
            } else {
                // 既不是运算符也不是括号（理解为操作数）
                vals.push(Double.parseDouble(inS));
            }
        }
        StdOut.println(vals.pop());
    }
}
