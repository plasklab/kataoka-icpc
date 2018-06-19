/*
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_7_B&lang=jp
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
        void print() {
            StringBuilder sb = new StringBuilder();
            sb.append("node ");
            sb.append(id);
            sb.append(": parent = ");
            sb.append(parent);
            sb.append(", sibling = ");
            sb.append(bro);
            sb.append(", degree = ");
            sb.append(deg);
            sb.append(", depth = ");
            sb.append(depth);
            sb.append(", height = ");
            sb.append(height);
            sb.append(", ");
            sb.append(nodeType);
            System.out.println(new String(sb));
        }
    }


    int findRoot(boolean[] rs) {
        for (int i = 0; i < rs.length; i++) {
            if (!rs[i]) return i;
        }
        System.out.println("could not find root.");
        return -1;
    }

    int search(Node[] nodes, int id, int depth, int parent, int bro) {
        nodes[id].depth = depth;
        nodes[id].parent = parent;
        nodes[id].bro = bro;

        int left_id  = nodes[id].left;
        int right_id = nodes[id].right;

        int left_height = 0, right_height = 0;
        if (left_id != -1) {
            left_height  = search(nodes, left_id, depth+1, id, right_id);
        }
        if (right_id != -1) {
            right_height = search(nodes, right_id, depth+1, id, left_id);
        }
        nodes[id].height = Math.max(left_height, right_height);
        if (parent == -1) {
            nodes[id].nodeType = "root";
        } else if (left_id == -1 && right_id == -1) {
            nodes[id].nodeType = "leaf";
        } else {
            nodes[id].nodeType = "internal node";
        }
        return nodes[id].height + 1;
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
            //Arrays.sort(childs);
            nodes[id] = new Node(id, left, right);
            if (left != -1) couldNotRoot[left] = true;
            if (right != -1) couldNotRoot[right] = true;
        }
        int root = findRoot(couldNotRoot);
        search(nodes, root, 0, -1, -1);
        for (int i = 0; i < nodes.length; i++) {
            nodes[i].print();
        }
    }
    public static void main(String[] args) {
        new Main().run();
    }
}
