/*
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_5_B&lang=jp
 */
import java.util.*;

public class Main {
	
	int[] A;
	int nSwap = 0;
	
	void printArray(int[] a) {
		System.out.print(a[0]);
		for (int i = 1; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.println();
	}
	
	void merge(int left, int mid, int right) {
		//System.out.println("#: " + left + ", " + mid + ", " + right);
		//printArray(A);
		int n1 = mid - left;
		int n2 = right - mid;
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		for (int i = 0; i < n1; i++) L[i] = A[left + i];
		for (int i = 0; i < n2; i++) R[i] = A[mid + i];
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		int i = 0, j = 0;
		for (int k = left; k < right; k++) {
			nSwap++;
			if (L[i] <= R[j]) {
				A[k] = L[i];
				i++;
			} else {
				A[k] = R[j];
				j++;
			}
		}
		//printArray(A);
		//System.out.println();
	}
	
	void mergeSort(int left, int right) {
		if (left + 1 < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid, right);
			merge(left, mid, right);
		}
	}
	
	void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		mergeSort(0, A.length);
		printArray(A);
		System.out.println(nSwap);
	}

	public static void main(String[] args) {
		new Main().run();
	}

}
