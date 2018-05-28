/*
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_2_B
 */

import java.util.Scanner;

class Card {
	static int[] appears = new int[10];
	int value;
	int appearNum;
	Card(int value) {
		this.value = value;
		appearNum = appears[value]++;
	}
}

public class Main {
	
	int count = 0;
	
	void swap(Card[] A, int a, int b) {
		Card tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
		count++;
	}
	
	void bubbleSort(Card[] A) {
		boolean f = true;
		while (f) {
			f = false;
			for (int i = A.length - 1; i >= 1; i--) {
				if (A[i].value < A[i-1].value) {
					Card tmp = A[i];
					A[i] = A[i-1];
					A[i-1] = tmp;
					f = true;
					count++;
				}
			}
		}
	}
	
	void selectionSort(Card[] A) {
		for (int i = 0; i < A.length; i++) {
			int minj = i;
			for (int j = i; j < A.length; j++) {
				if (A[j].value < A[minj].value) {
					minj = j;
				}
			}
			if (minj != i) swap(A, i, minj);
		}
	}
	
	void printCards(Card[] cards) {
		System.out.print(cards[0].value);
		for (int i = 1; i < cards.length; i++) {
			System.out.print(" " + cards[i].value);
		}
		System.out.println();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Card[] A = new Card[n];
		for (int i = 0; i < A.length; i++) {
			A[i] = new Card(scan.nextInt());
		}
		count = 0;
		selectionSort(A);
		System.out.print(A[0].value);
		for (int i = 1; i < A.length; i++) {
			System.out.print(" " + A[i].value);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}

}
