/*
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_4_C&lang=jp
 */
import java.util.*;

class Node {
	char c;
	List<Node> childs = new LinkedList<Node>();
	boolean isRoot = false;
	boolean isTerminator = false;
	Node() {
		this.isRoot = true;
	}
	Node(char c, boolean isTerminator) {
		this.c = c;
		this.isTerminator = isTerminator;
	}
	Node get(char childChar) {
		for (Node node : childs) {
			if (node.c == childChar) return node;
		}
		return null;
	}
	Node dig(char c, boolean isTerminator) {
		Node node = get(c);
		if (node == null) {
			node = new Node(c, isTerminator);
			childs.add(node);
		}
		if (isTerminator && !node.isTerminator) node.isTerminator = true; 
		return node;
	}
	public String toString() {
		String ret = "\'" + String.valueOf(c) + "\'";
		for (Node node : childs) {
			ret += " " + node.c;
		}
		return ret;
	}
}

public class Main {
	void insert(Node root, String str) {
		char[] ca = str.toCharArray();
		Node node = root;
		for (int i = 0; i < ca.length; i++) {
			node = node.dig(ca[i], i==(ca.length-1));
		}
	}
	boolean find(Node root, String str) {
		//System.out.println("### " + str);
		char[] ca = str.toCharArray();
		//System.out.println("root: " + root.toString());
		Node node = root;
		for (int i = 0; i < ca.length; i++) {
			node = node.get(ca[i]);
			//System.out.println(ca[i] + " : " + (node != null));
			if (node == null) return false;
		}
		return node.isTerminator;
	}
	void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Node root = new Node();
		for (int i = 0; i < n; i++) {
			String cmd = sc.next();
			String str = sc.next();
			if (cmd.equals("insert")) {
				insert(root, str);
			} else if (cmd.equals("find")) {
				if (find(root, str)) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
			}
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
