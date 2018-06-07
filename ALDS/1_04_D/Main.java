/*
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_4_D&lang=jp
 */

import java.util.*;


class Main {

  int n=0, k=0;
  int[] W;

  boolean solve3(int p) {
    int space = p;
    int rk = k;
    for (int i = 0; i < W.length; i++) {
      space -= W[i];
      if (space < 0) {
        rk--;
        if (rk == 0) {
          return false;
        }
        space = p;
        space -= W[i];
      }
    }
    return true;
  }

  int solve(int lower, int upper) {
    int mid = (upper + lower) / 2;
    if (lower+1 >= upper) return upper;
    if (solve3(mid)) return solve(lower, mid);
    else return solve(mid, upper);
  }

  void run() {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    k = sc.nextInt();
    W = new int[n];
    int max = 0, sum = 0;
    for (int i = 0; i < n; i++) {
      W[i] = sc.nextInt();
      max = Math.max(max, W[i]);
      sum += W[i];
    }

    if (solve3(max)) System.out.println(max);
    else System.out.println(solve(max, sum));
  }
  static public void main(String[] args) {
    new Main().run();
  }
}
