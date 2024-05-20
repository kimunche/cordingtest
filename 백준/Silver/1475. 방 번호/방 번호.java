import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int[] nums = new int[10];

        for(int i=0; i<s.length();i++){
            int num = Character.getNumericValue(s.charAt(i));
            if(num == 6){
                nums[9]++;
            }else {
                nums[num]++;
            }
        }

         int max =0;
        int nine = nums[9]%2 == 1 ? nums[9]/2+1 : nums[9]/2; ;

        for(int i=0; i<9; i++){
            max = Math.max(max, nums[i]);
        }

        max = Math.max(nine, max);

        System.out.println(max);
    }
}