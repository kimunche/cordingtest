import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {

        

        HashMap<Integer, Double> map = new HashMap<>();

        for(int i=1; i<=N; i++){
            double fail =0;
            double pass =0;
            for(int j : stages){
                if(i==j){
                    fail++;
                }
                if(j>=i){
                    pass++;
                }
            }

            map.put(i,fail/pass);
            if(pass ==0 && fail ==0){
                map.put(i,0.0);
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());

        list.sort((o1, o2)-> map.get(o2).compareTo(map.get(o1)));
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}