class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        long target = Long.parseLong(p);
        int len = p.length();

        for(int i=0;i<t.length(); i++){
            if(i+len <= t.length()){
                long num =Long.parseLong(t.substring(i,i+len));
                if(target >= num){
                    answer++;
                }
            }
        }

        return answer;
    }

}