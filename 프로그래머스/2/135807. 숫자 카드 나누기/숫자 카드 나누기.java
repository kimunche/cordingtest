class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        //최대공약수 구하기
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for(int i=1; i<arrayA.length; i++){
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        if (!divide(arrayB, gcdA)){
            answer = Math.max(answer,gcdA);
        }
        if (!divide(arrayA, gcdB)){
            answer = Math.max(answer,gcdB);
        }

        return answer;
    }

    public int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    public boolean divide(int[] arr, int gcd){
        for(int i: arr){
            if(i % gcd == 0){
                return true;
            }
        }
        return false;
    }
}