/*
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_2_D&lang=jp
 */

import java.util.*;

public class Main {
	int m = 0;
	int count = 0;
	int[] g = new int[100];

	void insertionSort(int[] array, int g) {
		for (int i = g; i < array.length; i++) {
			int v = array[i];
			int j = i - g;
			while (j >= 0 && array[j] > v) {
				array[j+g] = array[j];
				j = j - g;
				count++;
			}
			array[j+g] = v;
		}
	}
	void shellSort(int[] array) {
		count = 0;
		int h = array.length;
		while (true) {
			h /= 2;
			g[m++] = h;
			if (h <= 1) break;
		}
		for (int i = 0; i < m; i++) {
			insertionSort(array, g[i]);
		}
	}
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = scan.nextInt();
		}
		shellSort(array);
		System.out.println(m);
		for (int i = 0; i < m; i++) {
			System.out.print(g[i] + " ");
		}
		System.out.println();
		System.out.println(count);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
