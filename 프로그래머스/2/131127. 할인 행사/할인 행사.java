import java.util.*;

class Solution {
     public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        //1. 원하는 제품 map
        Map<String, Integer> wMap = new HashMap<>();

        for(int i = 0; i < want.length; i++){
            wMap.put(want[i], number[i]);
        }

        int consecutiveDays = 10;

        //2. 연속해서 할인 제품 구매할 수 있는 날짜를 세야하니 길이를 다음과 같이 정해서 for문을 돌린다.
        for (int i = 0; i < discount.length - consecutiveDays + 1; i++) {
            Map<String, Integer> dMap = new HashMap<>();

            //3. 할인하는 제품과 개수를 dMap에 저장한다.
            for (int j = 0; j < consecutiveDays; j++) {
                dMap.put(discount[i + j], dMap.getOrDefault(discount[i + j], 0) + 1);
            }

            Boolean wantNumberExist = true;

            //4. 할인하는 제품의 개수와 원하는 제품의 개수를 비교한다.
            for(String key : wMap.keySet()) {
                if(wMap.get(key) != dMap.get(key)) {
                    wantNumberExist = false;
                    break;
                }
            }

            //5. 개수가 일치하면 answer를 1씩 증가한다.
            if(wantNumberExist) {
                answer++;
            }
        }


        return answer;
    }
}