import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int hIdx =0;
        for(int i=0; i<citations.length; i++){
            int h = Math.min(citations[i], citations.length-i); // 현재 논문의 인용 횟수와 남은 논문의 개수 중 작은 값을 선택
            hIdx = Math.max(hIdx, h);// 이전 H-Index와 비교하여 최대값 선택
        }

        return hIdx;
    }
}