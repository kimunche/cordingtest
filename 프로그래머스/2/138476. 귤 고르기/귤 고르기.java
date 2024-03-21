import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        int[] types = new int[tangerine[tangerine.length - 1] + 1];

        for (int i = 0; i < tangerine.length; i++) {
            types[tangerine[i]]++;
        }

        Arrays.sort(types);

        int count = 0;
        int total = 0;

        for (int i = types.length - 1; i >= 0; i--) {
            if (types[i] == 0) continue;
            count += types[i];
            total++;
            if (count >= k) {
                break;
            }
        }

        return total;
    }
}