import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int temp = 64;
        int cnt = 0;

        while(X>0){
           if(temp > X){
               temp /= 2;
           }else{
               X = X-temp;
               cnt++;
           }
        }
        System.out.println(cnt);
    }
}