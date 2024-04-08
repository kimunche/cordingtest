import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] booking = new int[book_time.length][2];

        int i =0;
        //퇴실시간 10분 더하기
        for(String[] time : book_time){
            int start = Integer.parseInt(time[0].replace(":",""));
            int end = Integer.parseInt(time[1].replace(":",""))+10;

            if(end %100 >=60){
                end+= 40;
            }

            booking[i][0] = start;
            booking[i][1] = end;
            i++;
        }

        //입실시간 기준 정렬
        Arrays.sort(booking, (a, b) -> {
            return a[0] - b[0];
        });

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparing(a -> a[1]));

        for(int[] book : booking){
            if(priorityQueue.isEmpty()){
                priorityQueue.add(book);
            } else {
                int end = priorityQueue.peek()[1];
                if(book[0] >= end){
                    priorityQueue.poll();
                }
                priorityQueue.add(book);
            }
        }

        return priorityQueue.size();
    }
}