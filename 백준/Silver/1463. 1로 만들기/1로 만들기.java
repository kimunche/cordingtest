import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int min;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;

        dfs(n,0);

        System.out.println(min);

    }

    private static void dfs(int n, int cnt) {
        if(n == 1){
            min = Math.min(min, cnt);
            return;
        }
        if(cnt>= min){
            return;
        }

        //X가 2로 나누어 떨어지면, 2로 나눈다.
        if(n%2 ==0){
            dfs(n/2, cnt+1);
        }

        //X가 3로 나누어 떨어지면, 2로 나눈다.
        if(n%3 ==0){
            dfs(n/3, cnt+1);
        }

        //1 빼기
        dfs(n-1, cnt+1);
    }

}