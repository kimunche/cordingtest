import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        int cnt = 1; // 해당 대각선의 칸의 개수, 1/1 부터 시작
        int sum = 0; // 해당 대각선의 전 대각선 칸 누적합

        while (true) {
            // 해당 대각선의 전 대각선 칸의 누적 칸 + 현재 해당하는 대각선의 칸의 개수보다 X번째가 작다는 것은
            // 현재 해당하는 대각선에 해당 X번째의 분수가 있다는 것!
            if(x <= sum + cnt){
                if(cnt % 2 == 1){ // 해당 대각선의 칸 개수가 홀수일때 => 분자+분모 = 짝수
                    //대각선의 개수가 홀수인 범위 내에서는 위쪽(↗︎) 으로 순회 -> 분자 감소, 분모 증가
                    //분자는 대각선에 있는 모든 칸의 개수 - (X - 해당 대각선의 전 대각선 칸누적 개수 -1)
                    System.out.println(cnt -(x - sum -1) + "/" + (x-sum));
                    break;
                }else {// 해당 대각선의 칸 개수가 짝수일때 => 분자+분모 = 홀수
                    //대각선의 개수가 짝수인 범위 내에서는 아래쪽(↙︎︎) 으로 순회 -> 분자 증가, 분모 감소
                    // ︎홀수와 반대로 계산하면 된다
                    System.out.println((x-sum) + "/" + (cnt -(x - sum -1)));
                    break;
                }
            }
            else {//아직 X번째 분수가 해당 대각선에 포함하지 않는 경우
                sum += cnt;
                cnt++; //대각선이 늘때마다 해당 칸의 개수도 +1늘기 때문에 +1
            }
        }
    }
}