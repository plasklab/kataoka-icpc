import java.util.*;

public class Main {
	/*
	boolean[] furui() {
		boolean[] tab = new boolean[100000001];
		tab[0] = tab[1] = true;
		for (int i = 2; i <= tab.length/2; i++) {
			if (tab[i]) continue;
			for (int j = i + i; j < tab.length; j+=i) {
				tab[j] = true;
			}
		}
		return tab;
	}*/

	boolean isPrime(int x) {
		if (x==2) return true;
		if (x < 2 || x % 2 == 0) return false;
		for (int i = 3; i <= Math.sqrt(x); i += 2) {
			if (x % i == 0) return false;
		}
		return true;
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] ary = new int[n];
		for (int i = 0; i < n; i++) {
			ary[i] = scan.nextInt();
		}
		//boolean[] table = furui();
		int count = 0;
		for (int i = 0; i < ary.length; i++) {
			/*
			if (table[ary[i]] == false) {
				count++;
				System.out.println(ary[i]);
			}*/
			if (isPrime(ary[i])) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}

}
