/*
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_7_C&lang=jp
 */

import java.util.*;
import java.util.Arrays;

public class Main {
    class Node {
        int id;
        int left = -1, right = -1;
        String nodeType = null;
        Node(int id, int left, int right) {
            this.id = id;
            this.left = left;
            this.right = right;
        }
        void print() {
            System.out.println(id + ", " + left + ", " + right);
        }
    }
    int[] result;
    int resultIndex;
    void postorder(Node[] nodes, int x) {
        if (nodes[x].left != -1)
            postorder(nodes, nodes[x].left);
        if (nodes[x].right != -1)
            postorder(nodes, nodes[x].right);
        result[resultIndex++] = x;
    }

    Node[] nodes;
    int[] pre;
    int[] in;
    int ap = 0;

    int search(int b1p, int b2p) {
        boolean debug = false;
        int center = -1;
        if (ap >= pre.length) {
            return -1;
        }
        int top = pre[ap];
        //if (top == 1) debug = true;
        if (b1p + 1 == b2p) {
            ap++;
            nodes[top] = new Node(top, -1, -1);
            return top;
        } else if (b1p >= b2p) {
            return -1;
        }
        for (int i = b1p; i < b2p; i++) {
            if (top == in[i]) {
                center = i;
                break;
            }
        }
        if (debug) {
            System.out.println("top: " + top);
            System.out.println("ap:  " + ap);
            System.out.println("b1p: " + b1p);
            System.out.println("cen: " + center + ", " + in[center]);
            System.out.println("b2p: " + b2p);
        }
        ap++;
        int left = search(b1p, center);
        //if (left != -1) ap++;
        if (debug) {
            System.out.println("ap r:" + ap + ", " + pre[ap]);
        }
        int right = search(center+1, b2p);
        nodes[top] = new Node(top, left, right);
        return top;
    }

    void printArray(int[] ary) {
        System.out.print(ary[0]);
        for (int i = 1; i < ary.length; i++) {
            System.out.print(" " + ary[i]);
        }
        System.out.println();
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nodes = new Node[n+1];
        pre = new int[n];
        in  = new int[n];
        int root = 0;
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            if (i == 0) root = id;
            pre[i] = id;
        }
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            in[i] = id;
        }
        search(0, nodes.length);
        result = new int[n];
        resultIndex = 0;
        postorder(nodes, root);
        System.out.print(result[0]);
        for (int i = 1; i < result.length; i++) {
            System.out.print(" " + result[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        new Main().run();
    }
}
