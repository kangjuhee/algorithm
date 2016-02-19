package chap28.younghoo.ex1;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    static int[][] adj = {
        {-1, 1, 2, -1},
        {0, -1, -1, 3},
        {0, -1, -1, -1},
        {0, 1, -1, -1}
    };

    static boolean[] visited = new boolean[4];

    static {
        Arrays.fill(visited, false);
    }

    public static String printNodeName(int node) {

        String rt = null;

        switch (node) {
            case 0:
                rt = "A";
                break;
            case 1:
                rt = "B";
                break;
            case 2:
                rt = "C";
                break;
            case 3:
                rt = "D";
                break;
        }
        return rt;
    }

    public static void dfs(int here) {

        System.out.println("노드 " + printNodeName(here) + " 방문");
        visited[here] = true;

        for (int i = 0; i < adj[here].length; i++) {
            int there = adj[here][i];
            if (there > -1 && !visited[there]) {
                System.out.println("노드 " + printNodeName(there) + " 로 이동");
                dfs(there);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("탐색 시작");
        dfs(0);
    }
}