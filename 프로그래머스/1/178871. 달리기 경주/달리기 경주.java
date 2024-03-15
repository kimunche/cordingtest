import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String,Integer> map = new HashMap<>();

        for(int i =0; i< players.length; i++){
            map.put(players[i],i);
        }

        for (String player : callings) {
            int rank = map.get(player);
            
            String front = players[rank -1];
            
            map.replace(front, rank);
            map.replace(player, rank-1);
            
            players[rank] = front;
            players[rank-1] = player;
        }
        

        return players;
    }
    
}