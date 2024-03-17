import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Map<String,Integer>> give = new HashMap<>();
        Map<String, Integer> receive = new HashMap<>(); // 선물지수 : (총 준 선물 수) - (총 받은 선물 수)
        Map<String, Integer> nextMonthGiven = new HashMap<>();

        for(String f : friends){
            give.put(f,new HashMap<>());
            receive.put(f,0);
            nextMonthGiven.put(f,0);
        }

        for(String gift : gifts){
            String[] g = gift.split(" ");
            String giver = g[0];
            String receiver = g[1];

            give.get(giver).put(receiver, give.get(giver).getOrDefault(receiver,0)+1);
            receive.put(giver, receive.get(giver)+1);
            receive.put(receiver, receive.get(receiver)-1);
        }

        for(String giver : friends){
            for(String receiver : friends) {
                if (!giver.equals(receiver)) {
                    int giverP = give.get(giver).getOrDefault(receiver, 0);
                    int receiverP = give.get(receiver).getOrDefault(giver, 0);

                    if (giverP > receiverP) {
                        nextMonthGiven.put(giver, nextMonthGiven.get(giver) + 1);
                    } else if (giverP == receiverP) {
                        int gReceiveP = receive.get(giver);
                        int rReceiveP = receive.get(receiver);

                        if (gReceiveP > rReceiveP) {
                            nextMonthGiven.put(giver, nextMonthGiven.get(giver) + 1);
                        }
                    }
                }
            }
        }

        return Collections.max(nextMonthGiven.values());
    }
}