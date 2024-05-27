import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][5];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; st.hasMoreTokens();j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int stu = -1;
        int max = -1;

        for(int i=0; i<n; i++){
            int cnt = 0;

            for(int j =0; j<n; j++){
                if(i == j){
                    continue;
                }
                for(int k=0; k<5; k++){
                    if(arr[i][k] == arr[j][k]){
                        cnt++;
                        break;
                    }
                }
            }

            if(cnt > max){
                max = cnt;
                stu = i+1;
            }
        }

        System.out.println(stu);
    }
}