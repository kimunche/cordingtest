import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {

        int[] arr = Arrays.stream(score)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue).toArray();

        int totalPrice = 0;
        PriorityQueue<Integer> box = new PriorityQueue<>();

        for(int i= 0; i<arr.length; i++){
            box.offer(arr[i]);
            if(box.size() == m){
                totalPrice += box.peek()*m; //(최저 사과 점수) x (한 상자에 담긴 사과 개수) x (상자의 개수)
                box.clear();
            }
        }

        return totalPrice;
    }
}