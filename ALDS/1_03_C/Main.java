/*
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_3_C&lang=jp
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
	final boolean usesc = false;

	void run() {
		int n = 0;
		Scanner sc = null;
		BufferedReader br = null;
		if (usesc) {
			sc = new Scanner(System.in);
			n = sc.nextInt();
		} else {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				n = Integer.parseInt(br.readLine());
			} catch (Exception e) {
				System.exit(-1);
			}
		}
		Dll dll = new Dll();
		for (int i = 0; i < n; i++) {
			String line = null;
			String cmd = null;
			int arg = 0;
			if (usesc) {
				cmd = sc.next();
			} else {
				try {
					line = br.readLine();
				} catch (Exception e) {
					System.exit(-1);
				}
				String[] s = line.split(" ");
				cmd = s[0];

				arg = s.length == 2 ? Integer.parseInt(s[1]) : -1;
			}

			if (cmd.equals("insert")) {
				if (!usesc) {
					dll.insert(arg);
				} else {
					dll.insert(sc.nextInt());
				}
			}
			else if (cmd.equals("delete")) {
				if (!usesc) {
					dll.delete(arg);
				} else {
					dll.delete(sc.nextInt());
				}
			}
			else if (cmd.equals("deleteFirst")) {
				dll.deleteFirst();
			}
			else if (cmd.equals("deleteLast")) {
				dll.deleteLast();
			}
			else System.out.println("ERROR");
		}
		dll.print();
		System.out.println();
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
