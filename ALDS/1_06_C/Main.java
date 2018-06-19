/*
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_6_C&lang=jp
 */

import java.util.*;
import java.util.Arrays;


public class Main {
    class Card implements Comparable {
        String s;
        int n;
        int m;
        Card(String s, int n) {
            this.s = s;
            this.n = n;
        }
        public String toString() {
            return s + " " + n;
        }
        public int compareTo(Object c) {
            return n - ((Card) c).n;
        }
    }
    void swap(Card[] A, int a, int b) {
        Card tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }
    int partition(Card[] A, int p, int r) {
        int x = A[r].n;
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j].n <= x) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i+1, r);
        return i+1;
    }
    void quickSort(Card[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            quickSort(a, p, q-1);
            quickSort(a, q+1, r);
        }
    }
    void printCards(Card[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    
    boolean isSameOrder(Card[] a, Card[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Card[] a = new Card[n];
        Card[] b = new Card[n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int x = sc.nextInt();
            a[i] = b[i] = new Card(s, x);
        }
        quickSort(a, 0, a.length-1);
        Arrays.sort(b);
        if (isSameOrder(a, b)) {
            System.out.println("Stable");
        } else {
            System.out.println("Not stable");
        }
        printCards(a);
    }
    public static void main(String[] args) {
        new Main().run();
    }
}
