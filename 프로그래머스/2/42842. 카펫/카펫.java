class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        //최소한의 갈색 격자 수를 가지고 있을 때의 가로와 세로 길이 = 가로와 세로의 합은 갈색 격자 수에 테두리 1줄을 더한 값
        int max = (brown +4)/2;

        //yellow 구하기
        for(int height=3; height<=max;height++){
            int width = max - height;
            int yellowCnt = (height - 2) * (width - 2); //주어진 가로와 세로 길이에서 테두리를 제외한 영역의 yellow 수를 계산

            // yellow 격자의 수가 주어진 yellow와 일치하면 정답
            if(yellowCnt == yellow){
                answer[0] = width;
                answer[1] = height;
                break;
            }
        }

        return answer;
    }
}