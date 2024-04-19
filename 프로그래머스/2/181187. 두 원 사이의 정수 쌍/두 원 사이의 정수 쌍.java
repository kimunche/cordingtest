class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        /*
         * 하나의 원 안쪽에있는 정수쌍을 구하는법 : 피타고라스의식  x^2+y^2 = r^2
         *
         * r = 문제에서 줌
         * x = 0~r 까지 탐색한다고 가정
         * y = y^2= r^2- x^2 (y = sqrt(r^2 - x^2))
         *
         * 두 원 r1과 r2가 있을 경우, 두 원에서 특정 x값에서의 y값을 각각 구한 후 큰 값에서 작은 값을 빼면 두 원 사이에 존재하는 점의 개수가 나타남
         * */

        //경계값인 x축 또는 y축을 하나씩만 고려해야하기 때문에 중복방지를 위해 1부터
        for(int x=1;x<=r2;x++){
            //작은 원의 경우 현재 위치보다 큰 값이 개수에 포함되기 때문에 구한 값을 올림 처리
            long minH = (long)Math.ceil(Math.sqrt(1.0*r1*r1 - 1.0*x*x));
            //큰 원의 경우 현재 위치보다 작은 값이 개수에 포함되기 때문에 구한 값을 내림 처리
            long maxH = (long)Math.floor(Math.sqrt(1.0*r2*r2 - 1.0*x*x));

            answer += (maxH - minH +1);
        }

        return answer*4;
    }
}