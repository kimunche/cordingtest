import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> que = new LinkedList<>();

        for(int i=0; i<progresses.length; i++){
            int days = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0 ){
                days++;
            }
            que.offer(days);
        }

        List<Integer> list = new ArrayList<>();

        while(!que.isEmpty()){
            int dep = 1;
            int cur = que.poll();

            while (!que.isEmpty() && cur >= que.peek()){
                dep++;
                que.poll();
            }

            list.add(dep);
        }


        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}