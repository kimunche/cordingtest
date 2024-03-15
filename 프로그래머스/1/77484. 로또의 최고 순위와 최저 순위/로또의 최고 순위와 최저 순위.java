import java.util.*;

class Solution {

        public int[] solution(int[] lottos, int[] win_nums) {
        int matched = 0; // 맞춘점수
        int zero = 0; // 0개수

        for(int z : lottos){
            if(z ==0){
                zero++;
            }else{
                for(int w : win_nums){
                    if(z==w){
                        matched++;
                        break;
                    }
                }
            }
        }

        int maxScore = matched + zero;
        int minScore = matched;

        int[] answer ={rank(maxScore), rank(minScore)};
    
        return answer;
    }
    
    public int rank(int num){
        if(num <2){
            return 6;
        }else {
            return 7-num;
        }
        
    }
}