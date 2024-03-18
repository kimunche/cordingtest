class Solution {
    public String solution(String X, String Y) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        int[] x = new int[10];
        int[] y = new int[10];

        for(String s: X.split("")){
            x[Integer.parseInt(s)]++;
        }
        for(String s: Y.split("")){
            y[Integer.parseInt(s)]++;
        }

        for(int i =0; i<=9; i++){
            while(x[i] >0 && y[i] >0){
                sb.append(i);
                x[i]--;
                y[i]--;
            }
        }

        if (sb.toString().isEmpty()){
            return  "-1";
        }else if (sb.toString().replaceAll("0","").isEmpty() ){
            return   "0";
        }

        answer = sb.reverse().toString();

        return answer;
    }
}