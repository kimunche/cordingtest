class Solution {
   int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        
        dq(arr,0,0, arr.length);
        return answer;
    }

    //영역 분할
    public void dq(int[][] arr, int x, int y, int size){
        // 현재 영역이 압축 가능하다면 answer 배열에 값 추가하고 반환
        if(check(arr,x,y,size)){
            answer[arr[x][y]]++;
            return;
        }
        
        //1번영역
        dq(arr, x, y, size/2);
        //2번
        dq(arr, x+size/2, y, size/2);
        //3번
        dq(arr, x, y+size/2, size/2);
        //4번
        dq(arr, x+size/2, y+size/2, size/2);
        
    }

    // 나누어진 영역에서 압축 가능한지 체크
    public boolean check(int[][] arr, int x, int y, int size){
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(arr[x][y] != arr[i][j]){
                    return false;
                }
            }
        }

        return true;
    }
}