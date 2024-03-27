import java.util.*;

class Solution {
     public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> processIdx = new LinkedList<>();
        PriorityQueue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<priorities.length; i++){
            processIdx.offer(i);
            priority.offer(priorities[i]);
        }

        while (!processIdx.isEmpty()){
            int cur = processIdx.poll();
            int pri = priorities[cur];

            if(pri == priority.peek()){ // 현재 프로세스의 우선순위가 가장 높은지 확인
                priority.poll();  // 우선순위가 가장 높은 경우 PriorityQueue에서 제거
                answer++; // 실행된 프로세스 수 증가

                if(cur == location){  // 현재 실행된 프로세스의 위치가 주어진 location과 일치하는지 확인
                    break;
                }
            }else{
                // 우선순위가 가장 높지 않은 경우, 다시 Queue에 넣어
                processIdx.offer(cur);
            }

        }

        return answer;
    }
}