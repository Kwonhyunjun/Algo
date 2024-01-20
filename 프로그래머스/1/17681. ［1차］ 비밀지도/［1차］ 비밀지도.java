import java.util.*; 

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int[][] map1 = new int[n][n]; 
        int[][] map2 = new int[n][n]; 
        
        for(int i=0; i<n; i++){
            int num = arr1[i];
            // System.out.println("num : " + num); 
            
            int cnt = n-1; 
            while(num > 0){
                map1[i][cnt] = num % 2; 
                num /= 2; 
                // System.out.println("cur : " + num); 
                cnt--; 
            }
            // if(num == 1){
            //     map1[i][cnt--] = 1;        
            // }
        }
        
        for(int i=0; i<n; i++){
            int num = arr2[i];
            // System.out.println("num : " + num); 
            
            int cnt = n-1; 
            while(num > 0){
                map2[i][cnt] = num % 2; 
                num /= 2; 
                // System.out.println("cur : " + num); 
                cnt--; 
            }
            // if(num == 1){
            //     map2[i][cnt--] = 1;        
            // }
        }
        
        
        for(int i=0; i<n ;i++){
            String str = ""; 
            for(int j=0; j<n; j++){
                if(map1[i][j] == 0 && map2[i][j] == 0){
                    str += " "; 
                }else{
                    str += "#"; 
                }
            }
            answer[i] = str; 
        }
        
        
        return answer;
    }
}