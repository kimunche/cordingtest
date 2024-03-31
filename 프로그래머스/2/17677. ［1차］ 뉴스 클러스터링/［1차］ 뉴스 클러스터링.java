import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();


        for(int i =0; i<str1.length(); i++){
            if(i+1 < str1.length()){
                String word = String.valueOf(str1.charAt(i))+ String.valueOf(str1.charAt(i+1));
                if(word.replaceAll("[^A-Z]*","").length() == 2){
                    list1.add(word);
                }
            }
        }

        for(int i =0; i<str2.length(); i++){
            if(i+1 < str2.length()){
                String word = String.valueOf(str2.charAt(i))+ String.valueOf(str2.charAt(i+1));
                if(word.replaceAll("[^A-Z]*","").length() == 2){
                    list2.add(word);
                }
            }
        }

        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> inter = new ArrayList<>();

        Collections.sort(list1);
        Collections.sort(list2);

        for(String s : list1){
            if(list2.remove(s)){
                inter.add(s);
            }
            union.add(s);
        }

        for(String s : list2){
            union.add(s);
        }

        //자카드 유사도
        double jak = 0;
        if(!union.isEmpty()){
           jak  = (double) inter.size() / (double) union.size();
        }else{
            jak =1;
        }

        answer = (int) (jak * 65536);

        return answer;
    }
}