import java.util.*; 

class Solution {
    /*
        bridge_length : 다리에 올라갈 수 있는 최대 트럭 개수
        weight : 다리가 견딜 수 있는 최대 트럭 무게
        truck_weights : 트럭 별 무게
    */
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int minute = 1; // 현재 시간
        int cur_weight = 0; // 다리 위에 있는 무게
        int idx = 0; // 지금 기다리고 있는 트럭의 순서
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{truck_weights[idx], minute+bridge_length});
        cur_weight += truck_weights[idx];
        minute++;
        idx++; 
        
        while(!q.isEmpty()){ // 지나가지 못한 트럭이 있다면    
            
            if(!q.isEmpty() && q.peek()[1] == minute){
                int[] out = q.poll(); 
                cur_weight -= out[0]; 
                // System.out.printf("%d초 %d 퇴장, 현재 다리 무게 : %d\n", 
                                  // minute, out[0], cur_weight);
            }
            
            if(idx < truck_weights.length&& cur_weight+truck_weights[idx] <= weight){
                q.add(new int[]{truck_weights[idx], minute+bridge_length});
                cur_weight = truck_weights[idx] + cur_weight; 
                // System.out.printf("%d초 %d번 트럭(%d)입장, 현재 다리 무게 : %d\n", 
                                  // minute, idx, truck_weights[idx],cur_weight);
                idx++;
            }
            
            minute++;
        }
        
        return minute-1;
    }
}