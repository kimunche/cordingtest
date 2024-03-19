import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int boat = 0;

        Arrays.sort(people);

        int light = 0; //젤 가벼운 사람 idx
        int heavy = people.length-1; //젤 무거운 사람 idx

        // 가장 가벼운 사람과 가장 무거운 사람을 함께 태우며 구명보트 개수 세기
        while (light<=heavy){
            if(people[light]+ people[heavy]<=limit){
                light++;
            }
            heavy--;
            boat++;
        }

        return boat;
    }
}