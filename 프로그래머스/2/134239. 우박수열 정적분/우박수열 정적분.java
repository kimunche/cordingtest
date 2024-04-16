import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];

        //우박수열
        List<Integer> list = new ArrayList<>();
        int y=k;
        list.add(y);
        while(y>1){
            if(y%2 == 0){
                y = y/2;
            }else{
                y = y*3+1;
            }
            list.add(y);
        }

        for(int i =0; i< ranges.length; i++){

            //현재 range의 정적분 범위 구하기
            int start = ranges[i][0];
            int end = list.size() -1 + ranges[i][1];

            //시작 범위 > 끝 범위
            if(start > end){
                answer[i] = -1;
                continue;
            }

            double sum =0;
            for(int j=start; j<end; j++){
                double now = list.get(j);
                double target = list.get(j+1);
                sum += (now + target) /2;
            }
            answer[i] = sum;

        }

        return answer;
    }
}