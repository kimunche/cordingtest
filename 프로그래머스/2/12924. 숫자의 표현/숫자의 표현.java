class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int start = 1; start <= n; start++) {
            int sum = 0;
            for (int current = start; current <= n; current++) {
                sum += current;
                if (sum == n) {
                    answer++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }
        return answer;
    }
}