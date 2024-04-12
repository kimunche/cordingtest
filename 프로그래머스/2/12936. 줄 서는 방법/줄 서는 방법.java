import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();

        long f =1;
        for(int i =1; i<=n; i++){
            list.add(i);
            f*=i;
        }

        k -=1;
        int idx = 0;
        while (list.size() > 0 ){
            f = f/n;
            answer[idx++] = list.remove((int)(k/f));
            k = k%f;
            n--;
        }

        return  answer;
    }
}