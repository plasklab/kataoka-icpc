import java.util.*;

public class Main {

	void insertionSort(int[] A) {
		for (int i = 1; i < A.length; i++) {
			int v = A[i];
			int j = i - 1;
			while (j >= 0 && A[j] > v) {
				A[j+1] = A[j];
				j--;
			}
			A[j+1] = v;
			printArray(A);
		}
	}

	void printArray(int[] A) {
		System.out.print(A[0]);
		for (int i = 1; i < A.length; i++) {
			System.out.print(" " + A[i]);
		}
		System.out.println();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < A.length; i++) {
			A[i] = scan.nextInt();
		}
		printArray(A);
		insertionSort(A);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}

}
