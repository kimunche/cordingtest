class Solution {
    public long solution(int n) {
        long answer = 0;
        long mod = 1234567;
        
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        
        for(int i=2; i<arr.length; i++){
            arr[i] = (int)((arr[i-1]+ arr[i-2]) % mod);
        }
        
        answer = arr[n];
        
        
        return answer;
    }
}