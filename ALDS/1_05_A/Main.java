/*
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_5_A&lang=jp
 */

import java.util.*;
public class Main {
	int[] A;
	byte[][] dp;
	boolean solve(int m, int d) {
		//System.out.println(m + ", " + d);
		if (d >= A.length) return false;
		if (dp[m][d] == 1) return true;
		else if (dp[m][d] == -1) return false;
		int x = m - A[d];
		if (x == 0) return true;
		else {
			boolean b = solve(m, d+1);
			if (!b && x > 0) b = solve(x, d+1);
			dp[m][d] = (byte) (b ? 1 : -1);
			return b;
		}
	}
	
	void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		A = new int[n];
		for (int i = 0; i < n; i++) A[i] = sc.nextInt();
		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			int m = sc.nextInt();
			dp = new byte[m+1][A.length];
			if (solve(m, 0)) System.out.println("yes");
			else System.out.println("no");
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}

}
