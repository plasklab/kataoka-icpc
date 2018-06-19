/*
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_7_A&lang=jp
 */

import java.util.*;
import java.util.Arrays;

public class Main {
    class Node {
        int id, p = -1, depth = -1;
        int[] childs;
        String nodeType = null;
        Node(int id, int[] childs) {
            this.id = id;
            this.childs = childs;
        }
        void childsStr(StringBuilder sb) {
            if (childs.length != 0) {
                //String s = "["+childs[0];
                sb.append("[");
                sb.append(childs[0]);
                
                for (int i = 1; i < childs.length; i++) {
                    sb.append(", ");
                    sb.append(childs[i]);
                    //s += (", " + childs[i]);
                }
                sb.append("]");
                return;
                //return s+"]";
            }
            //return "[]";
            sb.append("[]");
        }
        void print() {
            StringBuilder sb = new StringBuilder();
            sb.append("node ");
            sb.append(id);
            sb.append(": parent = ");
            sb.append(p);
            sb.append(", depth = ");
            sb.append(depth);
            sb.append(", ");
            sb.append(nodeType);
            sb.append(", ");
            childsStr(sb);
            //System.out.println("node "+id+": parent = "+p+", depth = "+depth+", "+nodeType+", "+childsStr());
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

    void search(Node[] nodes, int id, int depth, int parent) {
        if (nodes[id].depth != -1) {
            System.out.println("error");
            return;
        }
        if (nodes[id].childs.length != 0) {
            for (int i = 0; i < nodes[id].childs.length; i++) {
                search(nodes, nodes[id].childs[i], depth+1, id);
            }
            nodes[id].nodeType = "internal node";
        } else {
            nodes[id].nodeType = "leaf";
        }
        if (parent == -1) {
            nodes[id].nodeType = "root";
        }
        nodes[id].p = parent;
        nodes[id].depth = depth;
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] nodes = new Node[n];
        boolean[] couldNotRoot = new boolean[n];
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int k = sc.nextInt();
            int[] childs = new int[k];
            for (int j = 0; j < k; j++) {
                childs[j] = sc.nextInt();
                couldNotRoot[childs[j]] = true;
            }
            //Arrays.sort(childs);
            nodes[id] = new Node(id, childs);
        }
        int root = findRoot(couldNotRoot);
        search(nodes, root, 0, -1);
        for (int i = 0; i < nodes.length; i++) {
            nodes[i].print();
        }
    }
    public static void main(String[] args) {
        new Main().run();
    }
}
