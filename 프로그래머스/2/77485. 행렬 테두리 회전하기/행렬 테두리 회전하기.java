class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};

        int[][] square = makeSquare(rows,columns);

        return rotateNums(square, queries);
    }

    public int[][] makeSquare(int row, int col){
        int[][] square = new int[row][col];
        int val = 1;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++ ){
                square[i][j] = val;
                val++;
            }
        }
        return square;
    }

    public int[] rotateNums(int[][] square, int[][] queries){
        int[] answer = new int[queries.length];

        int minIdx =0;

        for(int[] query :  queries){
            int x1 = query[0]-1;
            int y1 = query[1]-1;
            int x2 = query[2]-1;
            int y2 = query[3]-1;

            int firstNum = square[x1][y2];
            int min = firstNum;

            //숫자를 우로 이동(상단)
            for(int i=y2-1; i>=y1; i--){
                min = Math.min(min, square[x1][i]);
                square[x1][i+1] = square[x1][i];
            }

            //숫자를 위로 이동(죄측)
            for(int i=x1+1; i<=x2; i++){
                min = Math.min(min, square[i][y1]);
                square[i-1][y1] = square[i][y1];
            }

            //숫자를 좌로 이동(하단)
            for(int i=y1+1; i<=y2; i++){
                min = Math.min(min, square[x2][i]);
                square[x2][i-1] = square[x2][i];
            }

            //숫자를 아래로 이동(우측)
            for(int i=x2-1; i>=x1; i--){
                min = Math.min(min, square[i][y2]);
                square[i+1][y2] = square[i][y2];
            }

            square[x1+1][y2] = firstNum;
            answer[minIdx] = min;
            minIdx++;
        }

        return answer;
    }
}