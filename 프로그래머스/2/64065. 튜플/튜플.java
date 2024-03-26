import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Integer> list = new ArrayList<>();

        s = s.substring(2, s.length()-2).replace("},{","-");

        String str[] = s.split("-");

        //문자열 길이를 기준으로 정렬
        Arrays.sort(str, (a,b) -> {return a.length() - b.length();});

        for(String st : str){
            String[] temp = st.split(",");

            for(int i =0; i< temp.length; i++){
                int n = Integer.parseInt(temp[i]);
                if(!list.contains(n)){
                    list.add(n);
                }
            }
        }

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
