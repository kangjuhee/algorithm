package chap21;

public class Fortress {
    /**
     * Switch문에서 Integer로 선언 시 Constant expression required 에러 발생
     * int로 바꾸면 되는데 왜 그런거지?
     * => switch문은 원시타입과 스트링 타입정도만 지원하기 때문
     */
    public static final int INNER_FORTRESS = 0;
    public static final int OUTER_FORTRESS = 1;
    public static final int NOT_IN_FORTRESS = 2;

    private int xpos;
    private int ypos;
    private int radius;

    public Fortress(int xpos, int ypos, int radius) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.radius = radius;
    }

    public int getXpos() {
        return xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public int getRadius() {
        return radius;
    }

    /**
     * 해당 성벽이 같은 위치에 있는 성벽인지 떨어져 있는 성벽인지 판단한다.
     * true : 같은 위치
     * false : 다른 위치(떨어져있는 성벽)
     * @return
     */
    public Integer getFortressPosition(Fortress fortress) {
        int distance = (int) Math.sqrt(Math.pow(fortress.getXpos() - this.getXpos(), 2)
                + Math.pow(fortress.getYpos() - this.getYpos(), 2));

        if (distance < (fortress.getRadius() + this.getRadius())) { // 내부에 있는 경우
            if (fortress.getRadius() > this.getRadius()) { // fortress의 반지름이 더 큰 경우(2)
                return INNER_FORTRESS;
            } else {
                return OUTER_FORTRESS;
            }
        } else {
            return NOT_IN_FORTRESS;
        }
    }
}
