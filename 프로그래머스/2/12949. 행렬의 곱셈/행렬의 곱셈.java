class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int r = arr1.length; 
        int c = arr2[0].length;
        
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                
                int num = 0; 
                
                // System.out.println(i + " " + j); 
                // System.out.println(arr2.length); 
                for(int k=0; k<arr2.length; k++){
                    // System.out.printf("arr1[%d][%d] + arr2[%d][%d]\n", i, k, k, j);
                    num += (arr1[i][k] * arr2[k][j]);
                }
                answer[i][j] = num; 
            }
        }
        
        
        return answer;
    }
}