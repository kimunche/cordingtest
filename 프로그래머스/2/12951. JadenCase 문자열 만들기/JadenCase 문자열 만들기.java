class Solution {
    public String solution(String s) {
        String answer = "";

        for(String word : s.split(" ")){
            if(word.length() == 0){
                answer += " ";
            }else{
                answer += word.substring(0, 1).toUpperCase();
                answer += word.substring(1).toLowerCase();
                answer += " ";
            }
        }

        //입력 받은 문자열의 맨 마지막이 " " 라면 바로 answer 
        if(s.substring(s.length()-1, s.length()).equals(" ")){
            return answer;
        }

        // 맨 마지막 " " 제거하고 answer 
        answer = answer.substring(0, answer.length()-1);
        return answer;
    }
}