import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, HashSet<String>> reportmap = new HashMap<>(); // 신고자 : 신고한 사람들
        Set<String> set = new HashSet<>(Arrays.asList(report)); // 신고내역
        Map<String, Integer> reportedCntMap = new HashMap<>(); //신고당한사람 : 신고당한 카운트


        for(String id : id_list){
            reportmap.put(id, new HashSet<>());
            reportedCntMap.put(id, 0);
        }

        for(String rep : set){
            String[] r = rep.split(" "); // 신고자, 신고당한자
            HashSet<String> reportedset = reportmap.get(r[0]);
            reportedset.add(r[1]);
            reportmap.put(r[0],reportedset);
            reportedCntMap.put(r[1], reportedCntMap.get(r[1])+1);
        }

        int idx =0;
        for(String id : id_list){
            HashSet<String> reportset = reportmap.get(id);
            for(String name : reportset){
               if(reportedCntMap.get(name) >= k){
                   answer[idx]+=1;
               }
            }
            idx++;
        }

        return answer;
    }
}