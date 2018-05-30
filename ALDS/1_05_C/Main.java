/*
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_5_C&lang=jp
 */

import java.util.*;

class Point {
	double x, y;
	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	void print() {
		System.out.printf("%.8f %.8f\n", x, y);
	}
}

public class Main {
	
	double dist(Point s, Point t) {
		double xd = t.x - s.x;
		double yd = t.y - s.y;
		return Math.sqrt(xd*xd + yd*yd);
	}
	
	void koch(int n, Point p1, Point p2) {
		if (n <= 0) return;
		n--;
		Point s = new Point((p1.x*2 + p2.x) / 3.0, (p1.y*2 + p2.y) / 3.0);
		Point t = new Point((p1.x + p2.x*2) / 3.0, (p1.y + p2.y*2) / 3.0);
		double ux = (t.x - s.x) * Math.cos(Math.toRadians(60)) - (t.y - s.y) * Math.sin(Math.toRadians(60)) + s.x;
		double uy = (t.x - s.x) * Math.sin(Math.toRadians(60)) + (t.y - s.y) * Math.cos(Math.toRadians(60)) + s.y;
		Point u = new Point(ux, uy);
		koch(n, p1, s);
		s.print();
		koch(n, s, u);
		u.print();
		koch(n, u, t);
		t.print();
		koch(n, t, p2);
	}
	
	void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Point p1 = new Point(0, 0);
		Point p2 = new Point(100, 0);
		
		p1.print();
		koch(n, p1, p2);
		p2.print();
	}

	public static void main(String[] args) {
		new Main().run();
	}

}
