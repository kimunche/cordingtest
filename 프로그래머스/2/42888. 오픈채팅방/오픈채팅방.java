import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> memberMap = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(String st : record){
            String[] info = st.split(" ");
            if(info.length == 3){
                memberMap.put(info[1],info[2]);
            }
        }

        for(String st : record){
            String[] info = st.split(" ");
            if(info[0].equals("Enter")){
                result.add(memberMap.get(info[1]) + "님이 들어왔습니다.");
            }
            if(info[0].equals("Leave")){
                result.add(memberMap.get(info[1]) + "님이 나갔습니다.");
            }
        }

        String[] answer = result.toArray(new String[result.size()]);

        return answer;
    }
}