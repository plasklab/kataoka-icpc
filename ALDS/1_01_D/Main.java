import java.util.*;

public class Main {
	
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int maxDiff = Integer.MIN_VALUE;
		int minVal = scan.nextInt();
		
		for (int i = 1; i < n; i++) {
			int val = scan.nextInt();
			int diff = val - minVal;
			if (maxDiff < diff) {
				maxDiff = diff;
			}
			if (minVal > val) {
				minVal = val;
			}
		}
		
		System.out.println(maxDiff);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}

}
