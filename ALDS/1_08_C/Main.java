/*
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_8_C&lang=jp
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
    Node find(Node t, int k) {
        if (t == null) return null;
        if (t.key == k) return t;
        if (t.key > k) return find(t.left, k);
        else return find(t.right, k);
    }
    void delete1(Node t, Node c) {
        Node p = t.parent;
        if (p == null) {
            this.tree = c;
        } else if (p.left == t) {
            p.left = c;
        } else if (p.right == t) {
            p.right = c;
        } else {
            System.out.println("ERROR delete1");
        }
        if (c != null) {
            c.parent = p;
        }
    }
    Node getNextNode(Node t) {
        if (t.left != null) {
            return getNextNode(t.left);
        } else if (t.right != null) {
            return getNextNode(t.right);
        } else return t;
    }
    Node getNextNodeInorder(Node t) {
        Node subt = null;
        if (t.right != null) {
            subt = t.right;
        } else {
            Node p = t.parent;
            while (p != null) {
                if (p.right != t) {
                    subt = p.right;
                    break;
                }
            }
        }
        if (subt == null) {
            System.out.println("ERROR");
        }
        return getNextNode(subt);
    }
    void delete(int k) {
        Node t = find(this.tree, k);
        if (t == null) return;
        if (t.left == null && t.right == null) {
            delete1(t, null);
            return;
        } else if (t.left == null) {
            delete1(t, t.right);
            return;
        } else if (t.right == null) {
            delete1(t, t.left);
            return;
        }
        Node y = getNextNodeInorder(t);
        t.key = y.key;
        if (y.left == null && y.right == null) {
            delete1(y, null);
            return;
        } else if (y.left == null) {
            delete1(y, y.right);
            return;
        } else if (y.right == null) {
            delete1(y, y.left);
            return;
        }
    }
    
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String inst = sc.next();
            if ("insert".equals(inst)) {
                insert(new Node(sc.nextInt()));
            } else if ("find".equals(inst)) {
                if (find(tree, sc.nextInt()) != null) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            } else if ("delete".equals(inst)) {
                delete(sc.nextInt());
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
