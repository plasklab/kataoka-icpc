/*
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_4_B&lang=jp
 */
import java.util.*;
import java.util.Arrays;

public class Main {
	
	boolean binSearch(int[] s, int x, int a, int b) {
		int left = 0;
		int right = s.length;
		while (left < right) {
			int mid = (left + right) / 2;
			if (s[mid] == x) return true;
			else if (s[mid] > x) right = mid;
			else left = mid + 1;
		}
		return false;
	}
	
	void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] s = new int[n];
		for (int i = 0; i < n; i++) {
			s[i] = sc.nextInt();
		}
		int q = sc.nextInt();
		int[] t = new int[q];
		for (int i = 0; i < q; i++) {
			t[i] = sc.nextInt();
		}
		Arrays.sort(s);
		
		int cnt = 0;
		for (int i = 0; i < q; i++) {
			if (binSearch(s, t[i], 0, s.length - 1)) cnt++;
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}

}
