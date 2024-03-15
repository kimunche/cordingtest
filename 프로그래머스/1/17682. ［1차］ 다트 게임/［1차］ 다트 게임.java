import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;

        Map<Character,Integer> map = new HashMap<>();
        map.put('S', 1);
        map.put('D', 2);
        map.put('T', 3);

        char[] chars = dartResult.toCharArray();

        List<Double> scores = new ArrayList<>();

        int duplicate_p = 0;
        int duplicate_m = 0;

        for(int i=0; i<chars.length; i++){
            if(Character.isDigit(chars[i]) ){
                if(chars[i+1] == '0'){
                    scores.add(Math.pow(10, map.get(chars[i+2])));
                }else {
                    scores.add(Math.pow(Character.getNumericValue(chars[i]), map.get(chars[i + 1])));        //제곱 : Math.pow(5, 2)
                }
            }
            if(chars[i] == '*'){
                duplicate_p+=i;
                if( scores.size()>1){
                    scores.set(scores.size()-2, scores.get(scores.size()-2)*2); //그전 점수(있다면) 두배
                    //중첩
                    if(i-duplicate_p == 3){
                        duplicate_p+=i;
                        scores.set(scores.size()-2, scores.get(scores.size()-2)*2); // 그전 점수 *2
                    }
                }
                scores.set(scores.size()-1, scores.get(scores.size()-1)*2); //해당 점수 두배
            }else if(chars[i] == '#'){
                duplicate_m+=i;
                if( scores.size()>1){
                    //중첩
                    if(i-duplicate_m == 3){
                        duplicate_m+=i;
                        scores.set(scores.size()-2, scores.get(scores.size()-2)*-2);
                    }
                }
                scores.set(scores.size()-1, scores.get(scores.size()-1)*-1); //해당 점수 마이너스
            }
        }

        for(double d : scores){
            answer+= d;
        }
        return answer;
    }
}