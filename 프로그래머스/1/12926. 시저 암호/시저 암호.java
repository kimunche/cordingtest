class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(char ch : s.toCharArray()){
            if(ch == ' '){
                answer += ch;
            }
            if (Character.isLowerCase(ch)) {
                char c = (char)((ch-'a'+n)%26+'a');
                answer += c;
            } else if (Character.isUpperCase(ch)){
                char c = (char)((ch-'A'+n)%26+'A');
                answer += c;
            }
        }

        return answer;
    }
}