import java.util.*;

class Solution {
        public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> dolls = new Stack<>();
        dolls.push(0);
        for(int m : moves){
            for (int i=0; i< board.length; i++){
                if(board[i][m-1] != 0){
                    if(dolls.peek() == board[i][m-1]){
                        dolls.pop();
                        answer+=2;
                    }else {
                        dolls.push(board[i][m-1]);
                    }
                    board[i][m-1] = 0;
                    break;
                }

            }
        }

        return answer;
    }
}