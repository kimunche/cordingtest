import java.util.*;

class Solution {
   public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> p = new PriorityQueue<>();

        int idx=0;
        for(int i=0; i<score.length; i++){
            p.add(score[i]);

            if(p.size() > k){
                p.poll();
            }

            answer[i] = p.peek();
        }

        return answer;
    }
}