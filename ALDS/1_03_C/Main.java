/*
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_3_C&lang=jp
 */

import java.util.*;

class Elem {
	int x;
	Elem prev, next;
	Elem(int x, Elem prev, Elem next) {
		this.x = x;
		this.prev = prev;
		this.next = next;
	}
}
class Dll {
	Elem head = null, tail = null;
	void insert(int x) {
		Elem next = head;
		head = new Elem(x, null, next);
		if (next != null) next.prev = head;
		if (tail == null) tail = head;
	}
	void delete(int x) {
		Elem e = head;
		while (e != null) {
			if (e.x == x) {
				if (e.prev == null && e.next == null) {
					tail = head = null;
					break;
				}
				if (e.prev != null) {
					e.prev.next = e.next;
				} else {
					e.next.prev = null;
					this.head = e.next;
				}
				if (e.next != null) {
					e.next.prev = e.prev;
				} else {
					e.prev.next = null;
					this.tail = e.prev;
				}
				break;
			} else {
				e = e.next;
			}
		}
	}

	void deleteFirst() {
		if (head != null) {
			if (head == tail) head = tail = null;
			else {
				head = head.next;
				head.prev = null;
			}
		}
	}

	void deleteLast() {
		if (tail != null) {
			if (head == tail) head = tail = null;
			else {
				tail = tail.prev;
				tail.next = null;
			}
		}
	}

	void print() {
		if (head != null) {
			System.out.print(head.x);
			Elem e = head.next;
			while (e != null) {
				System.out.print(" " + e.x);
				e = e.next;
			}
			//System.out.println("\n tail: " + tail.x);
		}
	}
	void printRev() {
		if (tail != null) {
			System.out.print(tail.x);
			Elem e = tail.prev;
			while (e != null) {
				System.out.print(" " + e.x);
				e = e.prev;
			}
		} else {
			System.out.println("EMPTY");
		}
	}
}

public class Main {

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Dll dll = new Dll();
		for (int i = 0; i < n; i++) {
			String cmd = scan.next();
			//int x = scan.nextInt();
			if (cmd.equals("insert")) {
				dll.insert(scan.nextInt());
			}
			else if (cmd.equals("delete")) {
				dll.delete(scan.nextInt());
			}
			else if (cmd.equals("deleteFirst")) {
				dll.deleteFirst();
			}
			else if (cmd.equals("deleteLast")) {
				dll.deleteLast();
			}
			else System.out.println("ERROR");
			//dll.print();
			//System.out.println();
		}
		dll.print();
		System.out.println();
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
