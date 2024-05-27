import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int sum = a%b;

        for(int i=0; i<N-1; i++){
            sum*=10;
            sum%=b;
        }

        sum*=10;
        System.out.println(sum/b);
    }
}