import java.util.*;

class Solution {
    static Set<Integer> set;
    static boolean[] visited = new boolean[7];

    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();

        String[] str = numbers.split("");

        dfs(str, "", 0);

        for(int i : set){
            if(isPrime(i)){
                answer++;
            }
        }
        return answer;
    }

    public void dfs(String[] str, String num, int depth){
        if(depth> str.length){
            return;
        }

        for(int i=0; i<str.length; i++){
            if(!visited[i]){
                visited[i] = true;
                set.add(Integer.parseInt(num + str[i]));
                dfs(str, num+ str[i], depth+1);
                visited[i] = false;
            }
        }
    }

    public boolean isPrime(int num){
        if(num <2){
            return false;
        }

        for(int i =2; i<= Math.sqrt(num); i++){
            if(num%i==0){
                return false;
            }
        }

        return true;
    }
}