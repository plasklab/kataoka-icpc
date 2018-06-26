/*
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_8_B&lang=jp
 */

import java.util.*;

public class Main {
    class Node {
        int key;
        Node left = null, right = null, parent = null;
        Node(int key) {
            this.key = key;
        }
    }

    Node tree;

    boolean needPrefix = true;
    void inorder(Node t) {
        needPrefix = false;
        inorder_(t);
    }
    void inorder_(Node t) {
        if (t == null) {
            return;
        }
        if (t.left != null) {
            inorder_(t.left);
        }
        if (needPrefix) {
            System.out.print(" ");
        }
        System.out.print(t.key);
        needPrefix = true;
        if (t.right != null) {
            inorder_(t.right);
        }
    }

    void preorder(Node t) {
        needPrefix = false;
        preorder_(t);
    }
    void preorder_(Node t) {
        if (t == null) {
            return;
        }
        if (needPrefix) {
            System.out.print(" ");
        }
        System.out.print(t.key);
        needPrefix = true;
        if (t.left != null) {
            preorder_(t.left);
        }
        if (t.right != null) {
            preorder_(t.right);
        }
    }


    void insert(Node z) {
       Node y = null;
       Node x = tree;
       while (x != null) {
           y = x;
           if (z.key < x.key) {
               x = x.left;
           } else {
               x = x.right;
           }
       }
       z.parent = y;
       if (y == null) {
           this.tree = z;
       } else if (z.key < y.key) {
           y.left = z;
       } else {
           y.right = z;
       }
    }
    boolean find(Node t, int k) {
        if (t == null) return false;
        if (t.key == k) return true;
        if (t.key > k) return find(t.left, k);
        else return find(t.right, k);
    }
    
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String inst = sc.next();
            if ("insert".equals(inst)) {
                insert(new Node(sc.nextInt()));
            }else if ("find".equals(inst)) {
                if (find(tree, sc.nextInt())) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            } else {
                inorder_(tree);
                System.out.println();
                preorder_(tree);
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        new Main().run();
    }
}
