// import java.util.*;

// class Solution {
//     public int solution(int[] citations) {
//         int answer = 0;
        
//         int len = citations.length; 
        
//         Arrays.sort(citations);
        
//         System.out.println(Arrays.toString(citations));
        
//         // if(citations[0] == len){
//         //     return citations[0];
//         // }
        
//         boolean checked = false; 
//         int pointer = 0;
        
//         for(int i=0; i<citations[len-1]; i++){
            
//             System.out.printf("현재 인덱스 : %d , 현재 포인터 : %d\n", i,pointer); 
            
//             // System.out.printf("현재 인용수 : %d , 인용 이상인 논문의 수 %d\n", citations[i], (len-i)); 
// //             if(citations[i] == (len - i)){
                
// //                 answer = citations[i];
// //                 break; 
// //             }
            
//             while(citations[pointer] < i){
//                 pointer++; 
//             }
            
//             if(i >= (len-pointer)){
//                 checked = true; 
//                 answer = i; 
//                 break;
//             }
            
//         }
        
//         return answer;
//     }
// }

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int len = citations.length;
        
        for (int i = 0; i < len; i++) {
            int h = len - i;  // 현재 인덱스에서 남은 논문 수
            
            if (citations[i] >= h) {
                return h;
            }
        }
        
        return 0;
    }
}
