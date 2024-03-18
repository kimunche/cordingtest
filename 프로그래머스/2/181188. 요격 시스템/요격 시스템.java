import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets,(o1, o2) -> { //끝나는 시간 오름차순
            if(o1[1]==o2[1]){
                return o1[0]-o2[0];
            }
            return o1[1]-o2[1];
        });

        int shoot =targets[0][1];
        int answer = 1;

        for(int[] target : targets){
            if(shoot<= target[0]){
                shoot = target[1];
                answer++;
            }
        }

        return answer;
    }
}