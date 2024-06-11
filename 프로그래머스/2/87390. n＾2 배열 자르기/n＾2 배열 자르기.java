import java.util.*;

class Solution {
    
    static int[][] arr;
    
    public int[] solution(int n, long left, long right) {
        int len = (int) (right - left + 1); 
        int[] answer = new int[len];
        
        int start = 0;
        
        if(left != 0){
            start = (int)(left/n) + 1; 
        }
        // System.out.println(start);
        
        for(int i=0; i<len; i++){
            // System.out.println("i : " + i);
            
            int curCol = (int) ((left+i)%n);
            
            if(curCol == 0) {
                start++;
                // System.out.println("첫 행 시작 수 증가");
            }
            
            // System.out.println("start : " + start);
            // System.out.println("현재 행 : " + curCol); 
            
            if(curCol < start){
                answer[i] = start;
                // System.out.println("범위 내 : " + answer[i]);
            }else{
                answer[i] = start + (curCol - start) + 1; 
                // System.out.println("범위 밖 : " + answer[i]);
            }
            
        }
        
        
//         // 1. n행 n열 크기의 비어있는 2차원 배열을 만듦
//         arr = new int[n][n];
        
//         for(int i=0; i<n; i++){
//             for(int j=0; j<i+1; j++){ // 행
//                 for(int k=0; k<i+1; k++){
//                     // System.out.println(j+" , "+ k);
//                     if(arr[j][k] != 0) continue;
//                     arr[j][k] = i+1;
//                 }
//             }
//         }
        
//         for(int[] a : arr){
//             System.out.println(Arrays.toString(a));
//         }
        
        return answer;
    }
}