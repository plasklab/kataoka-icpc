/*
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_3_A&lang=jp
 */
import java.util.*;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int[] stack = new int[200];
		int sp = 0;
		while (scan.hasNext()) {
			String tok = scan.next();
			if (tok.equals("+")) {
				int b = stack[--sp];
				int a = stack[--sp];
				stack[sp++] = a + b;
			} else if (tok.equals("-")) {
				int b = stack[--sp];
				int a = stack[--sp];
				stack[sp++] = a - b;
			} else if (tok.equals("*")) {
				int b = stack[--sp];
				int a = stack[--sp];
				stack[sp++] = a * b;
			} else {
				int x = Integer.parseInt(tok);
				stack[sp++] = x;
			}
			//System.out.println(sp);
		}
		System.out.println(stack[0]);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
