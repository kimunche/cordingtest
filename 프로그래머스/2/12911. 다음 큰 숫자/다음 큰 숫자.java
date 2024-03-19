class Solution {
    public int solution(int n) {

        int cntOne = Integer.bitCount(n); //이진표현에서 1의 개수 반환

        while(true){
            n++;
            if(cntOne == Integer.bitCount(n)){
                break;
            }
        }

        return n;
    }
}