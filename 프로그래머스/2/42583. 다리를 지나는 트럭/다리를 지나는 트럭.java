import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;

        Queue<Integer> queue = new LinkedList<>();

        for(int t : truck_weights){
            while(true){
                if(queue.isEmpty()){ // 큐가 비어있으면 대기 트럭 넣기
                    queue.offer(t);
                    sum+=t;
                    answer++;
                    break;
                }
                else if (queue.size() == bridge_length){
                    sum-=queue.poll();
                }
                //큐가 비어있지 않을 때
                else {
                    if (sum + t > weight){
                        queue.offer(0);
                        answer++;
                    }
                    else {
                        queue.offer(t);
                        sum+=t;
                        answer++;
                        break;
                    }
                }
            }

        }

        return answer + bridge_length;
    }
}