class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        
        long needMoney = 0;
        for(int i=1; i<=count; i++){
            needMoney += price * i; 
        }

        if(money >= needMoney){
            answer = 0;
        }else{
            answer = needMoney - money;
        }
        
        return answer;
    }
}