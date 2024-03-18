class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] start = new int[2];
        int colLen = park[0].length();
        int rowLen = park.length;

        for(int i=0; i<park.length; i++){
            char[] chars = park[i].toCharArray();

            for(int j=0; j<chars.length; j++) {
                if (chars[j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }


        for(String r: routes) {
            String[] rout = r.split(" ");
            int x = Integer.parseInt(rout[1]);
            int now_col = start[1];
            int now_row = start[0];
            boolean flag = true;

            for (int i = 0; i < x; i++) {
                if (rout[0].equals("E")) { //동
                    if (now_col+1 >= colLen || park[now_row].charAt(now_col+1) == 'X') {
                        flag=false;
                        break;
                    }else{
                        now_col++;
                    }
                }
                if (rout[0].equals("W")) { //서
                    if (now_col-1 < 0 || park[now_row].charAt(now_col-1) == 'X') {
                        flag=false;
                        break;
                    }else {
                        now_col--;
                    }
                }
                if (rout[0].equals("S")) { //남
                    if (now_row+1 >= rowLen || park[now_row+1].charAt(now_col) == 'X') {
                        flag=false;
                        break;
                    }else{
                        now_row++;
                    }
                }
                if (rout[0].equals("N")) { //북
                    if (now_row-1 < 0 || park[now_row-1].charAt(now_col) == 'X') {
                        flag=false;
                        break;
                    }else{
                        now_row--;
                    }
                }

            }
            if(flag){
                start[0] = now_row;
                start[1] = now_col;
            }
        }

        return start;
    }
}