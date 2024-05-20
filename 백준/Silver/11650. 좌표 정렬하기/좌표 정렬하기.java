import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] ex = new int[n][2];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            int[] e = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            ex[i] = e;
        }

        Arrays.sort(ex, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);

        for(int[] a: ex){
            System.out.println(a[0]+" "+a[1]);
        }
    }
}