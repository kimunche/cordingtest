import java.util.*;

class Solution {
    static Map<String, ArrayList<Integer>> infoMap = new HashMap<>();
    public int[] solution(String[] info, String[] query) {

        int[] answer = new int[query.length];

        //모든 경우의 info 만들기
        for(String s : info){
            dfs(0,"", s.split(" "));
        }

        //infomap 의 점수 정렬 -> 이분탐색을 위함
        for(ArrayList<Integer> list : infoMap.values()){
            Collections.sort(list);
        }

        int idx = 0;
        for (String q : query){
            String[] data = q.split(" and ");

            String[] s = data[3].split(" ");
            int targetScore = Integer.parseInt(s[1]);
            data[3] = s[0];

            String key = String.join("", data);

            if(infoMap.containsKey(key)){
                ArrayList<Integer> list = infoMap.get(key);

                //이분탐색
                int start =0;
                int end = list.size()-1;

                while (start <= end){
                    int mid = (start+end)/2;

                    if(list.get(mid) < targetScore){
                        start = mid +1;
                    }else{
                        end = mid -1;
                    }
                }

                answer[idx] = list.size() - start;
            }

            idx++;
        }

        return answer;
    }

    private void dfs(int depth, String query, String[] info){
        if(depth == 4){
            if(!infoMap.containsKey(query)){
                ArrayList<Integer> score = new ArrayList<>();
                score.add(Integer.parseInt(info[4]));
                infoMap.put(query, score);
            }
            else {
                infoMap.get(query).add(Integer.parseInt(info[4]));
            }
            return;
        }

        dfs(depth+1, query+"-", info);
        dfs(depth+1, query+info[depth], info);
    }
}