// 누적합 -> 1부터 n가지의 누적합이 들어있는 배열을 정의하고 범위만큼 타겟 숫자가 있는지 확인

import java.util.*; 

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] hap = new int[n+1];
        
        hap[0] = 0; 
        
        for(int i=1; i<hap.length; i++){
            hap[i] = hap[i-1] + i;
        }
        
        // System.out.println(Arrays.toString(hap));
        
        for(int i=0; i<hap.length-1; i++){
            // System.out.println(hap[i]); 
            
            for(int j=i+1; j<hap.length; j++){
                if(hap[j] - hap[i] > n) break;
                
                if(hap[j] - hap[i] == n){
                    // System.out.println(j + " " + i); 
                    answer++; 
                    break; 
                }
            }
        }
        
        return answer;
    }
}