/*
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_2_C
 */

import java.util.Scanner;

class Card {
	static int[] appears = new int[37];
	String raw;
	int value;
	int appearNum;
	Card(int value, String raw) {
		this.raw = raw;
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
	
	boolean isStable(Card[] cards) {
		int prevVal = 0;
		int numCont = 0;
		for (int i = 0; i < cards.length; i++) {
			if (prevVal == cards[i].value) {
				if (numCont == cards[i].appearNum) {
					numCont++;
				} else {
					System.out.println(cards[i].value + " " + numCont);
					return false;
				}
			} else {
				if (cards[i].appearNum != 0) return false;
				prevVal = cards[i].value;
				numCont = 1;
			}
		}
		return true;
	}

	void printCards(Card[] cards) {
		System.out.print(cards[0].raw);
		for (int i = 1; i < cards.length; i++) {
			System.out.print(" " + cards[i].raw);
		}
		System.out.println();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] ary = new int[37];
		Card[] A = new Card[n];
		Card[] B = new Card[n];
		for (int i = 0; i < A.length; i++) {
			String in = scan.next("[A-Z][1-9]");
			int x = Integer.parseInt(in.substring(1));
			A[i] = B[i] = new Card(x, in);
		}
	
		count = 0;
		bubbleSort(A);
		printCards(A);
		if (isStable(A)) {
			System.out.println("Stable");
		} else {
			System.out.println("Not stable");
		}
		
		count = 0;
		selectionSort(B);
		printCards(B);
		if (isStable(B)) {
			System.out.println("Stable");
		} else {
			System.out.println("Not stable");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}

}
