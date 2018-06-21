/*
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_7_C&lang=jp
 */

import java.util.*;
import java.util.Arrays;

public class Main {
    class Node {
        int id, parent = -1, depth = -1, height = -1, bro = -1;
        int left = -1, right = -1, deg = 0;
        String nodeType = null;
        Node(int id, int left, int right) {
            this.id = id;
            this.left = left;
            this.right = right;
            if (left != -1) deg++;
            if (right != -1) deg++;
        }
    }

    int findRoot(boolean[] rs) {
        for (int i = 0; i < rs.length; i++) {
            if (!rs[i]) return i;
        }
        System.out.println("could not find root.");
        return -1;
    }

    void preorder(Node[] nodes, int x) {
        System.out.print(" " + x);
        if (nodes[x].left != -1)
            preorder(nodes, nodes[x].left);
        if (nodes[x].right != -1)
            preorder(nodes, nodes[x].right);
    }
    void inorder(Node[] nodes, int x) {
        if (nodes[x].left != -1)
            inorder(nodes, nodes[x].left);
        System.out.print(" " + x);
        if (nodes[x].right != -1)
            inorder(nodes, nodes[x].right);
    }
    void postorder(Node[] nodes, int x) {
        if (nodes[x].left != -1)
            postorder(nodes, nodes[x].left);
        if (nodes[x].right != -1)
            postorder(nodes, nodes[x].right);
        System.out.print(" " + x);
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] nodes = new Node[n];
        boolean[] couldNotRoot = new boolean[n];
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int left = sc.nextInt();
            int right = sc.nextInt();
            nodes[id] = new Node(id, left, right);
            if (left != -1) couldNotRoot[left] = true;
            if (right != -1) couldNotRoot[right] = true;
        }
        int root = findRoot(couldNotRoot);
        System.out.println("Preorder");
        preorder(nodes, root);
        System.out.println("\nInorder");
        inorder(nodes, root);
        System.out.println("\nPostorder");
        postorder(nodes, root);
        System.out.println();
    }
    public static void main(String[] args) {
        new Main().run();
    }
}
