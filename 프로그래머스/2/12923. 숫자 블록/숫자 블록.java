class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin) +1];

        for(int i=0; i< answer.length; i++){
            long num = begin+i;

            //약수 구하기
            int max_div = 1;
            for(long div=2; div<=Math.sqrt(num); div++){
                if(num%div == 0){
                    //최대 10억의 제곱근이므로 약 3만으로, 천만 이하인지 검사X
                    int div1 = (int) div;
                    //최대 10억 / 2,  5억이므로 천만이하인지 검사 필요함
                    int div2 = (int) (num/div);
                    
                    if(div2 <= 10000000){
                        max_div = Math.max(max_div, div2);
                    }else{
                        max_div = Math.max(max_div, div1);
                    }
                }
            }
            answer[i] = max_div;
        }

        if(begin ==  1){
            answer[0] = 0;
        }

        return answer;
    }
}