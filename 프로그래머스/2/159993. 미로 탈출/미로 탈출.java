import java.util.*;

class Solution {
    char[][] miro;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};

    public int solution(String[] maps) {
        miro = new char[maps.length][maps[0].length()];

        for(int i=0; i<maps.length; i++){
            miro[i] = maps[i].toCharArray();
        }

        int[] start = new int[2];
        int[] labor = new int[2];

        for(int row=0; row< miro.length; row++){
            for (int col=0; col<miro[row].length; col++){
                if(miro[row][col] == 'S'){
                    start = new int[]{row,col};
                }
                if(miro[row][col] == 'L'){
                    labor = new int[]{row,col};
                }
            }
        }

        //labor 까지의 최단거리
        int result = bfs(start,'L');
        int result2 = bfs(labor,'E');

        if (result == -1 || result2 == -1)
            return -1;

        return result + result2;
    }

    private int bfs(int[] start, char target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});

        boolean[][] visited = new boolean[miro.length][miro[0].length];

        while (!queue.isEmpty()){
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            int count = queue.peek()[2];

            visited[x][y] = true;

            if (miro[x][y] == target){
                return count;
            }

            queue.poll();

            for (int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<miro.length && ny>=0 && ny < miro[0].length && !visited[nx][ny]){
                    if(miro[nx][ny] != 'X'){
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx,ny, count+1});
                    }
                }
            }
        }
        return -1;
    }

}