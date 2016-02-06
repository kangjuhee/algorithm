package chap21;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2younghoo {

    // Fortress list를 radius 순으로 정렬
    public static void sortFortress(List<Fortress> list) {
        list.sort(((o1, o2) -> o2.radius - o1.radius));
    }
    public static void sortInteger(List<Integer> list) { list.sort(((a, b) -> b - a)); }

    public static void findPath(List<Fortress> fortressList) {

        Fortress root = fortressList.get(0);
        // fortressList.remove(0);

        for (int i = 1 ; i < fortressList.size(); i++) {
            root.addChild(fortressList.get(i));
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < root.children.size(); i++) {
            list.add(getLevel(root.children.get(i)));
        }

        sortInteger(list);

        if (list.size() == 1) {
            System.out.println((list.get(0) + 1));
        } else {
            System.out.println((list.get(0) + list.get(1) + 2));
        }
    }

    public static int getLevel(Fortress fortress) {

        if (fortress.hasChild()) {
            int level = 0;
            for (int i = 0; i < fortress.children.size(); i++) {
                level = Math.max(level, getLevel(fortress.children.get(i)));
            }
            return level + 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);
 
        int testCase = sc.nextInt();

        for (int t = 0; t < testCase; t++) {

            int numFortress = sc.nextInt();
            List<Fortress> fortressList = new ArrayList<>();
            for (int i = 0; i < numFortress; i++) {
                fortressList.add(new Fortress(sc.nextInt(), sc.nextInt(), sc.nextInt()));
            }
            sortFortress(fortressList);
            findPath(fortressList); // 알고리즘
        }
    }
}


class Fortress {

    int xPos;
    int yPos;
    int radius;
    List<Fortress> children = new ArrayList<>();

    public Fortress(int xPos, int yPos, int radius) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }

    public boolean isChild(Fortress fortress) {
        int distance = (int)Math.sqrt(Math.pow(this.xPos-fortress.xPos, 2) + Math.pow(this.yPos-fortress.yPos, 2));
        return distance < this.radius;
    }

    // 아래와 같은 방식으로 child를 추가하고, 무작위로 데이터를 입력하는 경우 문제가 발생한다.
    // ex) (5, 5, 15), (5, 5, 5), (5, 5, 10)라는 데이터를 입력하는 경우
    //              (5, 5, 15)
    //                  |
    //              (5, 5, 10) ( (5, 5, 15)의 child)
    //                  |
    //              (5, 5, 5) ( (5, 5, 10)의 child)
    // 이와 같은 구조를 가져야 하지만, 아래와 같은 방식을 사용한다면
    //              (5, 5, 15)
    //                  |
    //              (5, 5, 10) ( (5, 5, 15)의 child)
    //                  |
    //              (5, 5, 5) ((5, 5, 15)의 child)
    // 과 같이 child가 꼬여버리게 된다.
    //
    // 이 문제를 해결하기 위해서는 초기 데이터 입력 시 모든 데이터를 반지름 기준으로 내림차순 정렬하고 입력해야한다.
    // 많은 데이터가 입력으로 들어오는 경우 정렬 또한 부담이지만 일단은 이 방식대로 구현해보려 한다.
    public void addChild(Fortress fortress) {

        for (int i = 0; i < children.size(); i++) {
            // 다음 child fortress 중 매개변수로 들어온 fortress를 child로 가질 수 있는 fortress로 자식 추가 임무를 넘김!
            if (children.get(i).isChild(fortress)) {
                children.get(i).addChild(fortress);
                return;
            }
        }

        children.add(fortress);
    }

    public boolean hasChild() {
        return !children.isEmpty();
    }
}
