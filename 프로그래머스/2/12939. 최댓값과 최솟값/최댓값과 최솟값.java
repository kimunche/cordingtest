class Solution {
    public String solution(String s) {
        String answer = "";

        String[] strings = s.split(" ");

        int max = Integer.parseInt(strings[0]);
        int min = Integer.parseInt(strings[0]);

        for(int i =0; i<strings.length; i++){
            max = Math.max(max, Integer.parseInt(strings[i]));
            min = Math.min(min, Integer.parseInt(strings[i]));
        }

        return answer = min+ " "+ max;
    }
}