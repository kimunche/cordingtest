class Solution {
    public long solution(long k, long d) {
        long answer = 0;

        for(long x=0; x<=d; x+=k){ // x좌표를 k 배수만큼 증가
            long y = (long) Math.sqrt(d*d - x*x); // [피타고라스 정리] x좌표에 대한 최대 y좌표값
            answer += y / k + 1; // 0~y 최대치 정수에서 k 배수인 숫자가 몇 개인지 확인 (0좌표 포함시켜야 하므로 +1)
        }
        return answer;
    }
}