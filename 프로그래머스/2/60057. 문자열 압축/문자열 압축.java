class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int len = s.length();

        if (s.length() == 1)
            return 1;

        // 압축을 시키기 위해선 앞의 길이와 뒤의 길이가 적어도 동일해야하므로
        // len / 2까지만 반복
        for (int i = 1; i <= len / 2; i++) {
            // pattern == 압축시킬 문자열 패턴
            String pattern = s.substring(0,i);
            int cnt = 1; // pattern 횟수
            String str ="";

            for(int j = i; j <= s.length() - i; j += i) {
                if (pattern.equals(s.substring(j, j + i))) {
                    cnt++;
                }else {
                    if(cnt > 1){
                        str += cnt + ""; //2 + ab = 2ab
                    }
                    str += pattern;
                    pattern = s.substring(j, j + i);
                    //초기화
                    cnt =1;
                }
            }

            // 마지막에 압축시키지 않은 문자열 패턴을 압축시키기
            if (cnt > 1) {
                str += cnt + "";
            }
            str += pattern;

            // i개 단위로 자르고 남은 문자열 길이
            int remain = s.length() % i;
            // 최솟값 갱신
            answer = Math.min(answer, str.length() + remain);
        }
        return answer;
    }
}