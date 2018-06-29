/*
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_6_A&lang=jp
 */
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    int parseInt(String s) {
        char[] ca = s.toCharArray();
        int ret = 0;
        int k = 1;
        for (int i = ca.length - 1; i >= 0; i--) {
            int x = (int) (ca[i] - '0');
            ret += (x*k);
            k *= 10;
        }
        return ret;
    }
    void printArray(int[] a) {
        boolean usePrintWriter = true;
        if (usePrintWriter) {
            PrintWriter out = new PrintWriter(System.out);
            out.print(a[0]);
            for (int i = 1; i < a.length; i++) {
                out.print(" ");
                out.print(a[i]);
            }
            out.flush();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(a[0]);
            for (int i = 1; i < a.length; i++) {
                sb.append(" ");
                sb.append(a[i]);
            }
            System.out.println(sb);
        }
    }
    int[] splitInt(String line, int n) {
        int[] ret = new int[n];
        int s = 0;
        for (int i = 0; i < n; i++) {
            char c;
            int pos = s;
            while (pos < line.length() && (c = line.charAt(pos)) != ' ') {
                pos++;
            }
            ret[i] = Integer.parseInt(line.substring(s, pos));
            s = pos + 1;
        }
        return ret;
    }
    
    void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        String line = null;
        try {
            n = Integer.parseInt(br.readLine());
            line = br.readLine();
        } catch (Exception e) {
            System.exit(-1);
        }
        int[] A = splitInt(line, n);
        final int SIZE = 10001;
        int[] B = new int[n];
        int[] C = new int[SIZE];
        for (int i = 0; i < n; i++) {
            C[A[i]]++;
        }
        for (int i = 1; i < SIZE; i++) {
            C[i] = C[i] + C[i-1];
        }
        for (int i = n-1; i>=0; i--) {
            B[C[A[i]]-1] = A[i];
            C[A[i]]--;
        }
        printArray(B);
        System.out.println();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
