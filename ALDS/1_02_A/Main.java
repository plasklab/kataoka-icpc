import java.util.*;

public class Main {
	
	int count = 0;
	
	void bubbleSort(int[] A) {
		boolean f = true;
		while (f) {
			f = false;
			for (int i = A.length - 1; i >= 1; i--) {
				if (A[i] < A[i-1]) {
					int tmp = A[i];
					A[i] = A[i-1];
					A[i-1] = tmp;
					f = true;
					count++;
				}
			}
		}
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < A.length; i++) {
			A[i] = scan.nextInt();
		}
		count = 0;
		bubbleSort(A);
		System.out.print(A[0]);
		for (int i = 1; i < A.length; i++) {
			System.out.print(" " + A[i]);
		}
		System.out.println();
		System.out.println(count);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}

}
