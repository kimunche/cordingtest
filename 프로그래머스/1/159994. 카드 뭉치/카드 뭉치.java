class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        int card1idx =0;
        int card2idx =0;

        for(int i =0; i< goal.length; i++){
            if (card1idx < cards1.length && goal[i].equals(cards1[card1idx])) {
                card1idx++;
                continue;
            }
            if (card2idx < cards2.length && goal[i].equals(cards2[card2idx])) {
                card2idx++;
                continue;
            }

            answer = "No";
            return answer;
        }

        return answer;
    }
}