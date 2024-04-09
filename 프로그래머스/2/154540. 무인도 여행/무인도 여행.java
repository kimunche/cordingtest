import java.util.*;

class Solution {
        int x =0;
    int y =0;
    int day =0;
    public int[] solution(String[] maps) {
        x=maps.length;
        y=maps[0].length();

        //map 만들기
        int[][] map = new int[x][y];

        for(int i =0; i<x; i++){
            char[] chars = maps[i].toCharArray();
            for(int j=0; j<chars.length; j++){
                if(chars[j] == 'X'){
                    map[i][j] = 0;
                }else {
                    map[i][j] = chars[j]-'0';
                }
            }
        }

        List<Integer> days = new ArrayList<>();
        boolean[][] visited = new boolean[x][y];

        for(int i =0; i<x; i++){
            for(int j =0; j<y; j++){
                if(!visited[i][j] && map[i][j] >0){
                    dfs(map, visited, i, j);
                    days.add(day);
                    day = 0;
                }
            }
        }

        //섬이 없는 경우
        if(days.isEmpty()) return new int[]{-1};

        Collections.sort(days);

        return days.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(int[][] map, boolean[][] visited, int i, int j) {
        //날짜 더하기
        day += map[i][j];
        //해당 위치 방문처리
        visited[i][j] = true;

        int[] upDown ={1,-1,0,0};
        int[] leftRight  ={0,0,1,-1};

        for(int n=0; n<4; n++){
            int x2 = i+ upDown[n];
            int y2 = j+ leftRight[n];

            // 범위 체크
            if(x2 < 0 || y2 < 0 || x2 >= x || y2 >= y) {
                continue;
            }

            // 방문 이력이 없고 섬이면
            if(!visited[x2][y2] && map[x2][y2] >0){
                dfs(map,visited, x2, y2);
            }

        }

    }
}