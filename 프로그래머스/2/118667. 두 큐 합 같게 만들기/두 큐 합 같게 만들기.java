import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i=0; i<queue1.length; i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        while (sum1 !=sum2){
            long val =0;
            if(queue1.length *3 < answer){
                return -1;
            }

            // 큰쪽 -> 작은쪽으로 보냄
            if(sum1 < sum2){
                val = q2.peek();
                q1.add(q2.poll());
                sum1 += val;
                sum2 -= val;
            } else if (sum2 < sum1) {
                val = q1.peek();
                q2.add(q1.poll());
                sum2 += val;
                sum1 -= val;
            }

            answer++;

        }

        return answer;
    }
}