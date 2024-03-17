import javax.management.StringValueExp;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public String solution(String new_id) {
        String answer = "";

        // 1. 대문자 -> 소문자 치환
        answer = new_id.toLowerCase();


        // 2. 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        answer = answer.replaceAll("[^a-z0-9-_.]","");

        // 3. 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        answer= answer.replaceAll("[.]{2,}", ".");

        // 4. 마침표(.)가 처음이나 끝에 위치한다면 제거
        answer= answer.replaceAll("^[.]|[.]$", "");

        // 5. 빈 문자열이라면, new_id에 "a"를 대입
        if(answer.isEmpty()){
            answer = "a";
        }

        //6. 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if (answer.length() >= 16){
            answer = answer.substring(0,15);
        }
        answer= answer.replaceAll("[.]$", "");


        // 7. 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if (answer.length() <=2){
            char last = answer.charAt(answer.length()-1);
            while(answer.length() < 3){
                answer = answer + last;
            }
        }
        return answer;
    }
}