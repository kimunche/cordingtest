class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String convert = Long.toString(n,k);

        String[] arr = convert.split("0");

        for(String str : arr){
            if(!str.equals("1") && !str.equals("")){
                long chk = Long.parseLong(str);
                if(isPrime(chk)){
                    answer++;
                }
            }
        }

        return answer;
    }

    public boolean isPrime(long str){
        boolean chk = true;
        if(str == 2) {
            return true;
        }
        for (int i=2; i<=Math.sqrt(str); i++ ){
            if(str%i == 0){
                chk = false;
            }
        }
        return chk;
    }
}