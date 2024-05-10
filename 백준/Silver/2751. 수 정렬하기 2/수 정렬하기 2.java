import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        for(int i =0; i<n; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort(Integer::compareTo);

        for(int val : list){
            sb.append(val).append('\n');
        }

        System.out.println(sb);
    }
}