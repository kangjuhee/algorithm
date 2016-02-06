package chap22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1younghoo {

    static TreeMap<Integer, Integer> map;

    public static int put(int key, int value) {
        if (isDominated(key, value)) {
            return map.size();
        }

        removeDominated(key, value);
        map.put(key, value);
        return map.size();
    }

    /**
     * 새로 들어온 좌표가 다른 좌표에 의해 지배당하는지 판별하는 함수
     * 
     * 새로 들어온 좌표보다 더 큰 x값이 존재하지 않는다면 지배당하지 않는다는 의미이므로
     * {@code false}를 반환하고, 그렇지 않다면 y값까지 비교하여 지배 유무를 판단한다. 
     * y좌표까지 작다면 x, y 두 좌표 모두 작다는 의미이므로 map에 들어갈 수 없다. 
     * @param key
     * @param value
     * @return
     */
    public static boolean isDominated(int key, int value) {
        if (map.higherKey(key) == null) {
            return false;
        } else {
            return value < map.get(map.higherKey(key));
        }
    }

    /**
     * 새로 들어온 좌표에 의해 제거될 다른 좌표들을 map에서 제거하는 함수
     * 
     * map은 x좌표의 크기대로 정렬되어 있기 때문에, lowerKey 메소드를
     * 호출하면 map에서 매개변수 x좌표보다 작은 x좌표들 중 가장 큰 x좌표가
     * 반환된다.
     * 이 좌표의 y좌표와 매개변수 y좌표를 비교하여 매개변수 y좌표가 더 크면,
     * 새로 들어온 좌표에 의해 지배당한다는 의미이므로 map에서 좌표를 제거한다.
     * 방금 제거된 좌표의 왼쪽, 그리고 그 왼쪽으로 계속 진행하며 제거할지를
     * 판단하는데, y좌표가 매개변수 y좌표보다 더 크다면 반복을 종료한다.
     * (이미 map은 x, y좌표대로 정렬되어 있기 때문에 현재 비교한 y좌표의
     * 왼쪽 좌표들은 항상 현재 y좌표보다 큰 값을 가지기 때문이다.)   
     * 
     * @param x
     * @param y
     */
    public static void removeDominated(int x, int y) {
        Integer lower = map.lowerKey(x);

        while (lower != null) {
            if (map.get(lower) < y) { // 새로 들어온 좌표에 의해 lower가 지배 당함
                map.remove(lower);
                lower = map.lowerKey(lower);
            } else {
                break;
            }
        }
    }
    /**
     * 자바에서 기본적으로 제공되는 Map 자료구조를 출력하고자 할때에는 다음과 같이 하면 된다.
     */
    public static void printMap() {
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> itr = set.iterator();
        while (itr.hasNext()) {
            Map.Entry<Integer, Integer> entry = itr.next();
            int key = entry.getKey();
            int value = entry.getValue();
            System.out.println("key : " + key + " value : " + value);
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine().trim());

        for (int t = 0; t < testCase; t++) {
            int totalNum = Integer.parseInt(br.readLine().trim());
            map = new TreeMap<>();
            int sum = 0;
            for (int i = 0; i < totalNum; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int numProblem = Integer.parseInt(st.nextToken());
                int numNoodle = Integer.parseInt(st.nextToken());
                sum += put(numProblem, numNoodle);
            }
            System.out.println(sum);
        }
    }
}
