/*
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_6_B&lang=jp
 */

import java.util.*;

public class Main {
    void swap(int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }
    int partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i+1, r);
        return i+1;
    }
    void printArray(int[] a, int x) {
        if (x == 0) {
            System.out.print("["+a[0]+"]");
        } else {
            System.out.print(a[0]);
        }
        for (int i = 1; i < a.length; i++) {
            if (x == i) {
                System.out.print(" ["+a[i]+"]");
            } else {
                System.out.print(" " + a[i]);
            }
        }
        System.out.println();
    }
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int x = partition(A, 0, n-1);
        printArray(A, x);
    }
    public static void main(String[] args) {
        new Main().run();
    }
}
