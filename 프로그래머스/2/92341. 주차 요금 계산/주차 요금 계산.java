import java.util.*;


class Solution {

    public int[] solution(int[] fees, String[] records) {

        Map<String, Integer> parking = new HashMap<>();
        Map<String, Integer> cost = new TreeMap<>();

        for(int i=0; i<records.length; i++){
            String[] rec = records[i].split(" ");

            int time = getMin(rec[0]);
            String carNum = rec[1];
            String state = rec[2];

            if(state.equals("IN")){
                parking.put(carNum, time);
            }
            if (state.equals("OUT")) {
                if(!cost.containsKey(carNum)){
                    cost.put(carNum, time - parking.get(carNum));
                }else{
                    cost.put(carNum, cost.get(carNum)+time-parking.get(carNum));
                }
                parking.remove(carNum);
            }

        }

        if(!parking.isEmpty()){
            for (String carNum : parking.keySet()) {
                Integer co = cost.get(carNum);
                co = (co == null) ? 0 : co;
                cost.put(carNum, co + (23 * 60 + 59) - parking.get(carNum));
            }
        }

        List<Integer> answer = new ArrayList<>(cost.size());
        for (Integer c : cost.values()) {
            int basicTime = fees[0];
            int basicCharge = fees[1];
            int unitTime = fees[2];
            int unitCharge = fees[3];

            // 요금 = 기본요금 + ((min-기본시간) / 단위시간) * 단위요금
            if (c <= basicTime) {
                answer.add(basicCharge) ;
            } else {
                answer.add((int) (basicCharge + Math.ceil((double) (c - basicTime) / unitTime) * unitCharge));
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public int getMin(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}