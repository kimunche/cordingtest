import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> que = new PriorityQueue<>();
        
        for(int i=0; i< scoville.length; i++){
            que.add(scoville[i]);
        }
        
        
        int ns =0;
        while(que.peek() < K){
            if(que.size()==1){
                return -1;
            }
            
            int f = que.poll();
            ns = f + (que.poll()*2);
            answer ++;
            que.add(ns);
        }
        
        return answer;
    }
}