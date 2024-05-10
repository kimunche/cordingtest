import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        //최대공약수
        long g = gcp(Integer.parseInt(s[0]), Integer.parseInt(s[1]));

        //최소공배수
        long l = (long) Integer.parseInt(s[0]) *Integer.parseInt(s[1])/g;

        System.out.println(l);
    }
    
    private static long gcp(long n, long m) {
        long a = Math.max(n,m);
        long b = Math.min(n,m);
        long r = a%b;

        a=b;
        b=r;

        if(b==0){
            return a;
        }
        return gcp(a,b);
    }
}
