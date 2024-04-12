class Solution {
    public int solution(int n) {
        int answer = 0;

        /*
        * n=1 -> 1개
        * n=2 -> 2개
        * n=3 -> 3개
        * n=4 -> 5개
        * n=5 -> 8개
        * 
        * => 피보나치 수열
        * */
        int[] fibo = new int[n];
        fibo[0] = 1;
        fibo[1] = 2;

        for(int i=2; i<n; i++){
            fibo[i] = (fibo[i-1] + fibo[i-2]) % 1000000007 ;
        }

        return fibo[n-1];
    }
}