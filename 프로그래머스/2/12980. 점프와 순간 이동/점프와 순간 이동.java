import java.util.*;

public class Solution {
    public int solution(int n) {
        int bat = 0;

        while (n>0){
            if(n%2==1){
                bat++;
            }
            n = n/2;
        }

        return bat;
    }
}