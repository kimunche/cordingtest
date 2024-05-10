import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<String> list = new ArrayList<>();

        int cnt =0;

        for(int i=0; i<n; i++){
            list.add(br.readLine());
        }

        for(String word : list){
            Stack<Character> stack = new Stack<>();
            stack.push(word.charAt(0));
            boolean flag = true;
            for(int i=1; i<word.length(); i++){
                if(stack.peek() != word.charAt(i) && stack.contains(word.charAt(i))){
                    flag = false;
                    break;
                }else{
                    stack.push(word.charAt(i));
                }
            }

            if(flag){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}