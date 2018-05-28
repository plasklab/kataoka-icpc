import java.util.*;

public class Main {
	
	int gcd(int x, int y) {
		if (x < y) {
			int tmp = x;
			x = y;
			y = tmp;
		}
		if (x % y == 0) return y;
		return gcd(y, x%y);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		System.out.println(new Main().gcd(x,y));
	}

}
