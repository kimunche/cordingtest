class Solution {
public int solution(int[] arr) {
        int answer = arr[0];

        for(int i=1; i<arr.length; i++){
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }


    //최소공배수 = a*b/최대공약수
    public int lcm(int a, int b) {
        return a * b / gcd(a,b);
    }

    //최대 공약수 구하기
    public int gcd(int n, int m){
        int a = Math.max(n,m);
        int b = Math.min(n,m);
        int r = a%b;

        a=b;
        b=r;

        if(b==0){
            return a;
        }
        return gcd(a,b);
    }

}