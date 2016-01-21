package chap21;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Q2younghoo {

    public static void find(List<Fortress> fortressList) {
        TreeNode rootNode = new TreeNode(fortressList.get(0));
        fortressList.remove(0);
        System.out.println("\n##### MAKE TREE #####\n");
        for (int i = 0; i < fortressList.size(); i++) {
            TreeNode treeNode = new TreeNode(fortressList.get(i));
            makeTree(rootNode, treeNode);
        }
        System.out.println("\n##### TRAVERSAL TREE #####\n");
        // find longest path
        findLongestPath(rootNode);
    }

    public static void makeTree(TreeNode rootNode, TreeNode treeNode) {
        if (rootNode.hasChild()) {
            Boolean sameBoundary = false;

            for (int i = 0; i < rootNode.getChildren().size(); i++) {

                switch (rootNode.getChildren().get(i).getFortress().getFortressPosition(treeNode.getFortress())) {
                    case Fortress.INNER_FORTRESS:
                        System.out.println("INNER FORTRESS");
                        sameBoundary = true;
                        treeNode.setParent(rootNode.getChildren().get(i).getParent());
                        treeNode.addChild(rootNode.getChildren().get(i));
                        rootNode.getChildren().get(i).setParent(treeNode);
                        break;
                    case Fortress.OUTER_FORTRESS:
                        System.out.println("OUTER FORTRESS");
                        sameBoundary = true;
                        makeTree(rootNode.getChildren().get(i), treeNode);
                        break;
                    case Fortress.NOT_IN_FORTRESS:
                        System.out.println("NOT IN FORTRESS");
                        sameBoundary = false;
                        break;
                }
            }

            if (!sameBoundary) {
                System.out.println(treeNode + " NODE HAS ADDED TO " + rootNode);
                rootNode.addChild(treeNode);
                treeNode.setParent(rootNode);
            }

        } else {
            System.out.println(treeNode + " NODE HAS ADDED TO " + rootNode);
            rootNode.addChild(treeNode);
            treeNode.setParent(rootNode);
        }
    }

    /**
     * Fortress 간에 가장 거리가 먼 경로를 찾는 메소드이다.
     * 가장 먼 경로는 다음과 같이 두 가지 경우이다.
     *
     * From 루트노드 To 리프노드
     * 1. 루트 노드로부터 하나의 서브트리만을 가진 경우에는 루트 노드에서 마지막 리프노드까지의
     * 거리가 가장 긴 루트이다.
     *
     * From 리프노드 To 리프노드
     * 2. 루트 노드에 여러개의 서브트리가 있는 경우 루트 노드로부터 각 마지막 리프노드들의
     * 거리 중 가장 긴 2개의 경로의 합이 거리가 가장 긴 루트이다.
     *
     * @param rootNode
     */
    public static int findLongestPath(TreeNode rootNode) {

        List<Integer> list = new ArrayList<>();

        getHeight(rootNode);

//        for (int i = 0; i < rootNode.getChildren().size(); i++) {
//            // list.add(getHeight(rootNode.getChildren().get(i)));
//            getHeight(rootNode.getChildren().get(i));
//        }

        list.stream().forEach((i) -> System.out.println(i));
        return 1;
    }

//    public static int getHeight(TreeNode treeNode) {
//
//        int depth = 0;
//
//        if (treeNode.hasChild()) {
//            for (int i = 0; i < treeNode.getChildren().size(); i++) {
//                depth += getHeight(treeNode.getChildren().get(i));
//            }
//            return depth + 1;
//        } else {
//            return depth;
//        }
//    }
    public static void getHeight(TreeNode treeNode) {

        if (treeNode.hasChild()) {
            System.out.println("TREE NODE INFO : " + treeNode);
            for (int i = 0; i < treeNode.getChildren().size(); i++) {
                getHeight(treeNode.getChildren().get(i));
            }
        } else {
            System.out.print("TREE NODE INFO : " + treeNode + " ");
            System.out.println("THIS IS LEAF NODE");
        }

    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream("./Q2_input.txt"));
        // Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {

            int numCastles = sc.nextInt(); // 성벽의 총 갯수
            List<Fortress> fortressList = new ArrayList<>();
            for (int j = 0; j < numCastles; j++) {
                fortressList.add(new Fortress(sc.nextInt(), sc.nextInt(), sc.nextInt()));
            }
            find(fortressList);
            System.out.println("TEST " + (i + 1) + " 종료");
        }
    }   
}
