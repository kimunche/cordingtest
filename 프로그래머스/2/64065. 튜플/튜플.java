import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Integer> list = new ArrayList<>();

        s = s.substring(2, s.length()-2).replace("},{","-");

        String str[] = s.split("-");

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

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