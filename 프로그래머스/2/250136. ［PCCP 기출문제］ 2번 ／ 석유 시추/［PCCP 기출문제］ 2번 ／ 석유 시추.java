import java.util.*;

class Solution {

    static int rSize, cSize;
    static int[][] fragments; // 각 칸이 몇 번 조각에 속해있는지 알려줄 배열
    static int fragmentIdx = 1; // 조각별 번호. 시작은 1번부터
    static Map<Integer, Integer> fragmentsInfo = new HashMap<>(); // 각 조각별 size 정보 담을 Map
    static boolean[][] visited; // 방문 정보

    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};

    public int solution(int[][] land) {
        int answer = 0;
        rSize = land.length;
        cSize = land[0].length;
        fragments = new int[rSize][cSize];
        visited = new boolean[rSize][cSize];

        for (int r = 0; r < rSize; r++) {
            for (int c = 0; c < cSize; c++) {
                if (visited[r][c] || land[r][c] == 0) {
                    continue;
                }

                initFragment(land, r, c);
            }
        }

        for (int c = 0; c < cSize; c++) {
            Set<Integer> fragmentTypes = new HashSet<>(); //조각 번호를 Set에 담아둠
            int tmpMaxAmount = 0;
            for (int r = 0; r < rSize; r++) {
                if (fragments[r][c] > 0) {
                    fragmentTypes.add(fragments[r][c]);
                }
            }

            for (Integer frg : fragmentTypes) {
                tmpMaxAmount += fragmentsInfo.get(frg);
            }

            answer = Math.max(answer, tmpMaxAmount);
        }

        return answer;

    }

    // 주어진 land를 순회하며 (1) 몇개의 조각이 존재하는지 + (2) 각 조각의 사이즈는 몇인지
    static void initFragment(int[][] land, int r, int c) {
        visited[r][c] = true;
        fragments[r][c] = fragmentIdx;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        int size = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            size++; // 새로운 칸이 들어올 때마다 사이즈 증가

            for (int d = 0; d < 4; d++) {
                int nxtR = cur[0] + dirR[d];
                int nxtC = cur[1] + dirC[d];

                if (nxtR < 0 || nxtR >= rSize || nxtC < 0 || nxtC >= cSize || visited[nxtR][nxtC] || land[nxtR][nxtC] == 0) {
                    continue;
                }

                visited[nxtR][nxtC] = true;
                fragments[nxtR][nxtC] = fragmentIdx; // 새로운 칸은 몇번 조각에 해당하는지 갱신
                q.add(new int[]{nxtR, nxtC});
            }
        }

        fragmentsInfo.put(fragmentIdx++, size); // 모든 조각을 다 처리하고 나서 조각의 size 갱신
    }
}