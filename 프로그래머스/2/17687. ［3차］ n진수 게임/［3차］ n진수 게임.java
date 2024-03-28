class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<=t*m; i++){
            String num = Integer.toString(i,n);
            for(int j =0; j<num.length(); j++){
                sb.append(num.toUpperCase().charAt(j));
            }
        }

        for(int i=0; i<sb.length(); i++){
            if(i+1 == p){
                answer += sb.charAt(i);
                p = i+1+m;
                if(answer.length() == t){
                    break;
                }
            }
        }

        return answer;
    }
}