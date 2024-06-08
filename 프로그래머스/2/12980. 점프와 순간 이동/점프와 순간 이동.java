import java.util.*;

public class Solution {
    
    static int target; 
    static int ans; 
    
    public int solution(int n) {
        ans = 0;
        target = n; 

        // move(0, 0); 
        
        while(n > 0){
            // System.out.println(n); 
            // System.out.println(n % 2);
            ans += n % 2; 
            n /= 2; 
        }
        

        return ans;
    }
    
//     static void move(int cur, int battery){
//         if(cur > target) return;
        
//         if(cur == target){
//             ans = Math.min(battery, ans); 
//             return; 
//         }
        
//         // 순간이동이 효율적인지 앞으로 나가는게 효율적인지 판단
//         if( cur ) // 순간이동을 할 위치까지 점프한다면 걸리는 배터리
        
        
// //         // 순간이동
// //         move(cur * 2, battery); 
        
// //         for(int i=cur*2; i<=target; i++){
// //             move(i, battery+i); 
// //         }
//     }
    
}