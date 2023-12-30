/*
두 배열을 하나로 만들어 원형리스트로 만든 다음 그 부분 순열이 총합/2와 같은지 체크 
근데 그 경우의 수가 하나가 아닐 수도 있기 때문에 모두 다 체크해봐야함 -> 시간 초과 우려
*/

import java.util.*; 

class Solution {
    static Queue<Integer> q1, q2; 
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
        
        long sum = 0; 
        
        for(int i=0; i<queue1.length; i++){
            sum += queue1[i] + queue2[i]; 
            q1.add(queue1[i]); 
            q2.add(queue2[i]); 
        }
        
        long target = sum / 2; 
        
        if(sum % 2 == 1) return -1;
        
        long temp = 0;
        
        for(int i=0; i<queue1.length; i++){
            temp += queue1[i]; 
        }
        // System.out.println(temp); 
        
        int cnt = 0; 
        for(int i=0; i<queue1.length * 3+1; i++){
            
            
            // System.out.printf("sum : %d, cnt : %d \n", temp, cnt);
            
            if(temp == target){
                answer = cnt; 
                break; 
                
            }else if(temp < target){ // q2 -> q1
                int num = q2.poll(); 
                q1.add(num); 
                temp += num; 
                cnt++; 
            }else{ // q1 -> q2 
                int num = q1.poll();
                q2.add(num); 
                temp-= num;
                cnt++; 
            }
        } 
        int sum1 = q1.stream()
                       .mapToInt(Integer::intValue)
                       .sum();
        
        int sum2 = q2.stream()
                       .mapToInt(Integer::intValue)
                       .sum();
        
        
        
        answer = sum1 == sum2 ? cnt : -1; 
        
//         while(true){
//             if(cnt == queue1.length * 3){
//                 answer = -1; 
//                 break; 
//             }
            
//             int temp = q1.stream()
//                        .mapToInt(Integer::intValue)
//                        .sum();
            
//             // System.out.printf("sum : %d, cnt : %d \n", temp, cnt);
            
//             if(temp == target){
//                 answer = cnt; 
//                 break; 
                
//             }else if(temp < target){ // q2 -> q1
//                 int num = q2.poll(); 
//                 q1.add(num); 
                
//                 cnt++; 
//             }else{ // q1 -> q2 
//                 int num = q1.poll();
//                 q2.add(num); 
                
//                 cnt++; 
//             }
            
        // }
        
        return answer;
    }
}

/*
         
*/