class Solution {
     public int[] solution(int[] sequence, int k) {
        int[] answer = new  int[2];

        int start=0;
        int end =0;
        int sum =0;

        int minLength = Integer.MAX_VALUE;

        while (end < sequence.length){
            // 현재 부분 수열의 합이 k보다 작으면 end를 이동시켜 부분 수열을 확장
            while (sum < k && end < sequence.length){
                sum+= sequence[end++];
            }

            if(sum == k && end-start < minLength){
                minLength = end - start;
                answer[0] = start;
                answer[1] = end-1;
            }

            while (sum>=k && start<=end){
                sum -= sequence[start++];

                if(sum == k && end - start <minLength){
                    minLength = end - start;
                    answer[0] = start;
                    answer[1] = end-1;
                }
            }
        }
        
        return answer;
    }
}