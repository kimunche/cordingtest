import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();

        for(int i=0; i<n; i++){
            set.add(br.readLine());
        }

        ArrayList<String> list = new ArrayList<>(set);

        Collections.sort(list, (o1, o2) ->  {
            int o1L = o1.length();
            int o2L = o2.length();
            if(o1L == o2L){
                return o1.compareTo(o2);
            }
            return o1L-o2L;
        });


        for(String s : list){
            sb.append(s).append('\n');
        }

        System.out.println(sb);
    }
}