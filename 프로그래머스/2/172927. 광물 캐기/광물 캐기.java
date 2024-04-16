import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {

        int fatigue = 0;
        int slength = (int) Math.ceil(minerals.length / 5.0);
        //slength이 곡괭이 개수보다 적으면 slength을 곡괭이 개수로 변경한다
        if (slength > picks[0] + picks[1] + picks[2]){
            slength = picks[0] + picks[1] + picks[2];
        }

        int[][] status = new int[slength][4];
        setStatus(status, minerals);

        //가중치에 따라 status를 내림차순으로 정렬
        Arrays.sort(status, ((o1, o2) -> o2[3] - o1[3]));

        int pInd = 0, sInd = 0;
        //곡괭이를 좋은 거부터 하나씩 쓰면서 정렬된 status대로 광물을 캔다.
        while (pInd < picks.length) {
            if (picks[pInd] == 0) {
                pInd++;
                continue;
            }

            picks[pInd]--;
            if (pInd == 0) fatigue += status[sInd][0] + status[sInd][1] + status[sInd][2];
            else if (pInd == 1) fatigue += status[sInd][0] * 5 + status[sInd][1] + status[sInd][2];
            else fatigue += status[sInd][0] * 25 + status[sInd][1] * 5 + status[sInd][2];
            sInd++;
            if (sInd >= status.length) break;
        }

        return fatigue;

    }

    private void setStatus(int[][] status, String[] minerals) {
        int cnt = 0, ind = 0;
        for (int i = 0; i < minerals.length; i++) {
            cnt++;

            if (minerals[i].equals("diamond")) status[ind][0]++;
            else if (minerals[i].equals("iron")) status[ind][1]++;
            else status[ind][2]++;

            // i번째 묶음 광물 5개의 상태를 status[i][0] ~ status[i][2]에 저장
            if (cnt == 5 || i == minerals.length - 1) {
                cnt = 0;
                //status[i][3]에는 가중치를 저장한다.
                status[ind][3] = 25 * status[ind][0] + 5 * status[ind][1] + status[ind][2];
                ind++;
            }

            if (ind >= status.length) break;
        }
    }
}