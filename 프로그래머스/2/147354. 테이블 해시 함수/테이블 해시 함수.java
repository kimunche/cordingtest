import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {

        int answer = 0;

        int idx = col-1;

        Arrays.sort(data, (o1, o2) -> o1[idx]!=o2[idx] ? o1[idx] - o2[idx] : o2[0] - o1[0]);

        List<Integer> list = new ArrayList<>();

        for (int i= row_begin; i<=row_end; i++){
            int sum =0;
            for(int j=0; j<data[i-1].length; j++){
                sum += (data[i-1][j] % i);
            }
            list.add(sum);
        }

        int xor = list.get(0);
        for(int i=1; i<list.size(); i++){
            xor ^= list.get(i);
        }

        return xor;
    }
}