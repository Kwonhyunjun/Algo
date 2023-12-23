import java.util.*; 

/*
cap : 트럭에 실을 수 있는 재활용 택배 상자의 최대 개수
n : 배달할 집의 개수
deliveries : 각 집에 배달할 재활용 택배 상자의 개수
pickups : 각 집에서 수거할 빈 재활용 택배 상자의 개수

트럭 하나로 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리

로직 정리
1. 최소 거리 : 멀리있는 택배를 처리해야함

*/

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0; 
        
        int dIdx = n-1; // 배달 가야하는 집 번호  4
        int pIdx = n-1; // 픽업 가야하는 집 번호  4
        
        while(dIdx != -1 || pIdx != -1){
            int bring = cap;
            int pick = 0; 
            int maxD = -1;  
            int maxP = -1;  
            
            // 배달
            while(bring > 0 && dIdx != -1){
                if(deliveries[dIdx] > 0){
                    maxD = maxD > dIdx ? maxD : dIdx; 
                    deliveries[dIdx]--; 
                    bring--;  
                }else{
                    dIdx--;
                }
            }
            
            // 픽업
            while(pick < cap && pIdx != -1){ 
                if(pickups[pIdx] > 0){
                    maxP = maxP > pIdx ? maxP : pIdx; 
                    pickups[pIdx]--; 
                    pick++;
                }else{
                    pIdx--; 
                }
            }
            // System.out.println(maxD + " " + maxP ); 
            answer += Math.max(maxD+1, maxP+1) * 2; 
            
        }
        
        return answer;
    }
}