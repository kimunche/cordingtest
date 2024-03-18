import java.util.*;

class Solution {
       public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();

        Map<String, Integer> termmap = new HashMap<>();

        long todays = getDate(today);

        for(String t : terms){
            String[] arr = t.split(" ");
            termmap.put(arr[0], Integer.parseInt(arr[1]));
        }

        for(int i=0; i< privacies.length; i++){
            String[] pr = privacies[i].split(" "); // [date, term]
            long date = getDate(pr[0]);
            long termdate = termmap.get(pr[1])*28;
            if(date+termdate <= todays){ // 오늘보다 작으면 파기
                result.add(i+1);
            }
        }

        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public long getDate(String date){
        String[] ymd = date.split("\\.");
        long year = Long.parseLong(ymd[0])*12*28;
        long month= Long.parseLong(ymd[1])*28;
        long day = Long.parseLong(ymd[2]);

        return year+month+day;
    }
}