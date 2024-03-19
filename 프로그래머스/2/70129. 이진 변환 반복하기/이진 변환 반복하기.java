class Solution {
    int cntZero =0;
    int cntCal = 0;
    int length =0;

    String num ="";
    public int[] solution(String s) {
        int[] answer = new int[2];

        binaryCal(s);

        answer[0] = cntCal;
        answer[1] = cntZero;

        return answer;
    }

    public String binaryCal(String s){
        StringBuilder binarynum = new StringBuilder();
        int zero=0;

        cntCal++;
        if(s.length() != 1){
            //0제거
            for(int i=0; i<s.length();i++){
                if(s.charAt(i) == '0'){
                    cntZero++;
                    zero++;
                }
            }

            length = s.length() - zero;

            if(length > 1) {
                while (length > 0) {
                    binarynum.append(length % 2);
                    length = length / 2;
                }

                return binaryCal(binarynum.reverse().toString());
            }
        }
        return "1";
    }
}