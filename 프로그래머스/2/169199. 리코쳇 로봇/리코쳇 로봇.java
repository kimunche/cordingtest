import java.util.*;

class Solution {
    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};

    private int n, m;

    private class Move{
         int x, y, depth;

         public Move(int x, int y, int depth){
             this.x = x;
             this.y = y;
             this.depth = depth;
         }

    }

    public int solution(String[] board) {

        Move robot = null;
        Move goal = null;

        n = board.length;
        m = board[0].length();

        for(int i =0; i< board.length; i++){
            for(int j=0; j< board[0].length(); j++){
                char ch = board[i].charAt(j);

                if(ch == 'R'){
                    robot = new Move(i,j,0);
                } else if (ch == 'G') {
                    goal = new Move(i,j,0);
                }
            }
        }

        int answer = bfs(board, robot, goal);
        return answer;
    }

    private int bfs(String[] board, Move robot, Move goal) {
        Queue<Move> queue = new LinkedList<>();
        queue.add(robot);
        boolean[][] visited = new boolean[n][m];
        visited[robot.x][robot.y] = true;

        while (!queue.isEmpty()){
            Move cn = queue.poll();

            // 현재 지점이 도착지점인지 체크
            if(cn.x == goal.x && cn.y == goal.y){
                return cn.depth;
            }

            // 4가지 방향으로 탐색해본다.
            for(int i=0; i<4; i++){
                int nx = cn.x;
                int ny = cn.y;

                // 범위를 벗어나거나 장애물을 만날 때 까지 반복
                while(true){
                    if(inRange(nx, ny) && board[nx].charAt(ny) != 'D'){
                        nx += dx[i];
                        ny += dy[i];
                    }else{
                        // 현재 지점은 보드 밖이거나, 장애물이 있는 지점이다. 직전의 좌표가 이동할 수 있는 좌표이다.
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                }

                // 해당 지점에 방문한적이 없다면, 해당 지점에서 탐색한다.
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new Move(nx, ny, cn.depth + 1));
                }
            }
        }

        return -1;

    }

    private boolean inRange(int x, int y) {
        if(0 <= x && x < n && 0 <= y && y < m)
            return true;
        return false;
    }
}