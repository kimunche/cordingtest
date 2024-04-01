import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        int[] prior = new int[order.length];
        for(int i=0; i< order.length; i++){
            prior[order[i]-1] = i;
        }

        Stack<Integer> extraCart = new Stack<>();

        for(int i=0; i< order.length; i++){
            if(prior[i] == answer){
                answer++;
            }else{
                extraCart.push(prior[i]);
            }

            while (!extraCart.isEmpty() && extraCart.peek() == answer){
                extraCart.pop();
                answer++;
            }
        }


        return answer;
    }
}