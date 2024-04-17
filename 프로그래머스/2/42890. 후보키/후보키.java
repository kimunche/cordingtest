import java.util.*;

class Solution {

    static int answer;
    static int n, m;
    List<HashSet<Integer>> setList;

    static String[][] relationCopy;

    public int solution(String[][] relation) {
        relationCopy = relation;
        answer = 0;

        n = relationCopy.length;
        m = relationCopy[0].length;

        // 중복 조합을 고려하여 HashSet 사용
        setList = new ArrayList<>();

        // 1부터 m까지 사이즈만큼 조합 생성하기
        for (int i = 1; i <= m; i++) {
            dfs(0, i, 0, new HashSet<>());
        }

        return answer;
    }

    private void dfs(int idx, int size, int depth, HashSet<Integer> set) {
        if (depth == size) {
            //유일성 검사
            if (!unique(set)) {
                return;
            }

            //최소성 검사
            for (HashSet<Integer> key : setList) {
                if (set.containsAll(key)) {
                    return;
                }
            }

            //조합 추가, answer++
            setList.add(set);
            answer++;
            return;
        }

        //조합 만들기
        for (int i = idx; i < m; i++) {
            HashSet<Integer> newSet = new HashSet<>(set);
            newSet.add(i);
            idx++;
            dfs(idx, size, depth + 1, newSet);
        }
    }

    private boolean unique(HashSet<Integer> set) {
        List<String> list = new ArrayList<>();

        // 만들어진 조합으로 중복되는지 검사
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int idx : set) {
                sb.append(relationCopy[i][idx]);
            }
            if (!list.contains(sb.toString())) {
                list.add(sb.toString());
            } else {
                return false;
            }
        }
        return true;
    }
}