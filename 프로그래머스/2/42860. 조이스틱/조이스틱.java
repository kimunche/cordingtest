class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = name.length() - 1; // 기본 최소 좌우이동 횟수 (좌, 우 커서)


        // 해당 커서 알파벳 변경 최솟값 (위, 아래 커서)
        for (int i = 0; i < len; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            // 연속된 'A'가 끝나는 지점 찾기
            int next = i + 1;
            while(next < len && name.charAt(next) == 'A') {
                next++;
            }

            // 좌우이동 최소 횟수 구하기 (순서대로 가기 vs 뒤로 돌아가기)
            move = Math.min(move, (i * 2) + len - next); //오른쪽으로 갔다가 왼쪽으로 시작점까지 돌아가서 마지막 위치로 이동
            move = Math.min(move, (len - next) * 2 + i); //시작점에서 왼쪽으로 움직여 마지막 위치에서 알파벳 바꾸고 다시 오른쪽으로 움직여 시작점으로 돌아옴
        }

        answer += move;
        return answer;
    }
}