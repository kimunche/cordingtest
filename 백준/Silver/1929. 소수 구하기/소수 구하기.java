import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = br.readLine().split(" ");

        int M = Integer.parseInt(strings[0]);
        int N = Integer.parseInt(strings[1]);

        StringBuffer sb = new StringBuffer();

        for (int i =2; i<=N; i++){
            if(isPrime(i) && i >= M) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
    }

    private static boolean isPrime(int n) {
        boolean result = true;

        if(n ==2){
            return result;
        }

        for(int i=2; i<=(int)Math.sqrt(n); i++){
            if(n%i == 0){ // 소수아남
                result = false;
                break;
            }
        }

        return result;
    }

}