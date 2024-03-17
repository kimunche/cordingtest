class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int healTime = bandage[0]; //시전시간
        int heal = bandage[1]; // 초당 회복량
        int exHeal = bandage[2]; // 추가 회복량
        int healIdx = 0; //연속성공
        int lastAttacktime = attacks[attacks.length-1][0]; // 마지막 공격 시간
        int life = health;

        int atIdx = 0;

        for(int i=1; i<=lastAttacktime; i++){
            //공격시간 == 현재시간
            if(attacks[atIdx][0] == i){
                life -= attacks[atIdx][1]; // 공격
                atIdx++;
                healIdx =0;
                if(life<=0){ // 사망
                    return -1;
                }
            }
            else {
                if(life < health){ // 현재 제력이 max체력보다 작으면
                    healIdx++;
                    life+= heal;
                    //추가 회복
                    if(healTime == healIdx){
                        life+=exHeal;
                        healIdx =0;
                    }

                    if(life > health){ //현재체력>max체력
                        life = health;
                    }

                }
            }
        }


        return life;
    }
}