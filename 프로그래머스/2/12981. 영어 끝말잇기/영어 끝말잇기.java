import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};//[번호,차례]

        Set<String> set = new HashSet<>();
        String checkLetter = words[0].substring(words[0].length()-1);

        for(int i=0; i<words.length; i++){
            //이미 있는 단어 체크
            if(!set.contains(words[i])){
                set.add(words[i]);
            }else{
                answer[0] = (i%n)+1;
                answer[1] = (i/n)+1;
                break;
            }

            //끝말잇기 체크
            if(i>0 && !checkLetter.equals(words[i].substring(0,1))){
                answer[0] = (i%n)+1;
                answer[1] = (i/n)+1;
                break;
            }
            checkLetter = words[i].substring(words[i].length()-1);
        }

        return answer;
    }
}