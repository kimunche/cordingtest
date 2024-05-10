import java.util.*;

class Solution {

    public static ArrayList<move> moveList;
    public int solution(String dirs) {
        moveList = new ArrayList<>();
        HashMap<Character, Point> direction = new HashMap<>();

        direction.put('L', new Point(-1,0));
        direction.put('R', new Point(1, 0));
        direction.put('U', new Point(0, 1));
        direction.put('D', new Point(0, -1));

        Point cur = new Point(0,0);

        for(char item : dirs.toCharArray()){
            Point temp = direction.get(item);
            int newX = cur.x + temp.x;
            int newY = cur.y + temp.y;

            if(newX > 5 || newX < -5 || newY >5 || newY <-5){
                continue;
            }

            if(!checkLine(cur.x, cur.y, newX, newY)){
                cur = new Point(newX, newY);
                continue;
            }

            moveList.add(new move(cur.x, cur.y, newX, newY));
            cur = new Point(newX, newY);
        }
        return moveList.size();
    }

    public static boolean checkLine(int curX, int curY, int nextX, int nextY){ // 되돌아가는 경우가 있는지 체크
        for(move item : moveList){
            if (item.fromX == curX && item.fromY == curY && item.toX == nextX && item.toY == nextY){
                return false;
            }
            if(item.fromX == nextX && item.fromY == nextY && item.toX == curX && item.toY == curY){
                return false;
            }
        }
        return true;
    }

    public static class move{
        int fromX;
        int fromY;
        int toX;
        int toY;

        public move(int fromX, int fromY, int toX, int toY) {
            this.fromX = fromX;
            this.fromY = fromY;
            this.toX = toX;
            this.toY = toY;
        }
    }

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}