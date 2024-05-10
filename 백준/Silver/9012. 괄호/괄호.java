import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            list.add(br.readLine());
        }

        for(String s : list){
            Stack<Character> stack = new Stack<>();
            char[] chars = s.toCharArray();
            boolean flag = true;
            for(char ch : chars){
                if(ch == '('){
                    stack.push(ch);
                } else if (!stack.isEmpty() && ch == ')' && stack.peek() == '(') {
                    stack.pop();
                }else if (stack.isEmpty() && ch == ')'){
                    flag = false;
                    break;
                }
            }
            if(stack.isEmpty() && flag){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

}