import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();

        for(int i=0;i<=elements.length; i++){
            int sum =0;
            for(int j=0; j<elements.length;j++){
                // 현재 위치 i에서 j번째 원소로 이동, 원형 수열이므로 배열의 길이 n으로 나눈 나머지를 취함
                sum += elements[(i+j)%elements.length]; 
                set.add(sum);
            }
        }
        return set.size();
    }
}