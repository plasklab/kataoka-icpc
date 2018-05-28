/*
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_4_A&lang=jp
 */
import java.util.*;
public class Main {
	
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
		int cnt = 0;
		for (int i = 0; i < q; i++) {
			for (int j = 0; j < n; j++) {
				if (s[j] == t[i]) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}

}
