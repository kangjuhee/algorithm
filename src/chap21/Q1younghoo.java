package chap21;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Q1younghoo {

    /**
     * int형 array를 first index부터 last index까지 자르는 함수이다.
     * @param arr
     * @param first
     * @param last
     * @return
     */
    public static int[] slice(int[] arr, int first, int last) {
        return Arrays.copyOfRange(arr, first, last + 1);
    }

    public static int find(int[] arr, int target) {
        int idx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    public static void traversal(int[] preOrder, int[] inOrder) {

        int parent = preOrder[0];
        preOrder = slice(preOrder, 1, preOrder.length-1);

        int rootIndexInInOrder = find(inOrder, parent);

        if (inOrder.length == 1) {
            System.out.print(inOrder[0] + " ");
            return;
        } else if (inOrder.length == 0) {
            return;
        }

        if (rootIndexInInOrder == -1) {
            traversal(preOrder, inOrder);
            return;
        }

        int[] leftInOrder = slice(inOrder, 0, rootIndexInInOrder - 1);
        int[] rightInOrder = slice(inOrder, rootIndexInInOrder + 1, inOrder.length - 1);

        traversal(preOrder, leftInOrder);
        traversal(preOrder, rightInOrder);
        System.out.print(parent + " ");

    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);
        // Scanner sc = new Scanner(new FileInputStream("./input.txt"));
        int numOfCase = sc.nextInt();

        /**
         * preOrder, inOrder list를 초기에 arrayList로 하려고 하였으나
         * slice를 간단히 구현해보기 위해 그냥 array로 선언하였다.
         */
        for (int i = 0; i < numOfCase; i++) {
            int numOfNode = sc.nextInt(); // 트리의 전체 노드 개수
            int[] preOrder = new int[numOfNode];
            int[] inOrder = new int[numOfNode];

            for (int j = 0; j < numOfNode; j++) {
                preOrder[j] = sc.nextInt();
            }

            for (int j = 0; j < numOfNode; j++) {
                inOrder[j] = sc.nextInt();
            }

            // 알고리즘 시작
            traversal(preOrder, inOrder);
        }
    }
}