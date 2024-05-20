import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int len = str.length();
        List<String> list = new ArrayList<>();

        for(int a=1; a<len; a++){
            for(int b=a+1; b< len; b++){
                list.add(getWord(str, a, b));
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }

    private static String getWord(String str, int a, int b) {
        StringBuilder s1 = new StringBuilder(str.substring(0, a));
        StringBuilder s2 = new StringBuilder(str.substring(a, b));
        StringBuilder s3 = new StringBuilder(str.substring(b));
        StringBuilder sb = new StringBuilder();
        sb.append(s1.reverse()).append(s2.reverse()).append(s3.reverse());
        return sb.toString();
    }
}