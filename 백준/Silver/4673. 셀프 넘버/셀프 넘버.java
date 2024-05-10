import java.util.*;

public class Main {
    public static void main(String[] args){
        int[] arr = new int[10000];

        for(int i=1; i<=10000; i++){
            int n = d(i);

            if(n <= 10000){
                arr[n-1] = 1; // 생성자를 가지고 있는 경우 그 (수-1)를 인덱스로 하여 1 입력
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i =0; i<10000; i++){
            if(arr[i] ==0){
                sb.append(i+1).append('\n');
            }
        }

        System.out.println(sb);

    }

    public static int d(int num){
        int sum = num;

        while (num !=0){
            sum = sum + (num % 10);
            num = num/10;
        }

        return sum;
    }
}