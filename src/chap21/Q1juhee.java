package chap21;
/* mistakes
놓친 exception : tree가 정렬되지 않을 경우. --> binarySearch를 사용했을 때 return -1 됨
                    --> 해결 : 직접 find함수로
*/
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1juhee {
    public static int find(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void printPostOrder(int[] pre, int[] in) {
        if (pre.length == 0) {
            return;
        }
        int root;
        root = pre[0];

        int left = find(in, root);
        if (left == -1) {
            throw new Error(new IndexOutOfBoundsException());
        }

        printPostOrder(Arrays.copyOfRange(pre, 1, left + 1), Arrays.copyOfRange(in, 0, left));//left
        printPostOrder(Arrays.copyOfRange(pre, left + 1, in.length), Arrays.copyOfRange(in, left + 1, in.length));//right
        System.out.print(root + " ");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine().trim());

        for (int t = 0; t < testCase; t++) {
            int numNodes = Integer.parseInt(br.readLine().trim());
            int[] pre = new int[numNodes];
            int[] in = new int[numNodes];

            StringTokenizer preSt = new StringTokenizer(br.readLine());
            for (int i = 0; i < numNodes; i++) {
                pre[i] = Integer.parseInt(preSt.nextToken());
            }
            StringTokenizer inSt = new StringTokenizer(br.readLine());
            for (int i = 0; i < numNodes; i++) {
                in[i] = Integer.parseInt(inSt.nextToken());
            }

            printPostOrder(pre, in);
            System.out.println();
        }
    }
}
