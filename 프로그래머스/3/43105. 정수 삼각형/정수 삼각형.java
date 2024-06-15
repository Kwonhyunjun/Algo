class Solution {
    
    /*
        return 거쳐간 숫자의 최댓값
    */
    
    public int solution(int[][] triangle) {
        int answer = 0;
        
        triangle[1][0] += triangle[0][0];
        triangle[1][1] += triangle[0][0];
        
        for(int i=2; i<triangle.length; i++){
            for(int j=0; j<i+1; j++){
                // System.out.printf("[%d][%d] => [%d][%d] or [%d][%d] \n", i, j, i-1,j-1, i-1,j);
                
                int prev = (j-1 < 0) ? triangle[i-1][j] : (j >= i) ? triangle[i-1][j-1] : Math.max(triangle[i-1][j-1], triangle[i-1][j]); 
                triangle[i][j] += prev; 
            }
        }
        
        int height = triangle.length-1; 
        for(int i=0; i<triangle[height].length; i++){
            answer = Math.max(answer, triangle[height][i]); 
        }
        
        return answer;
    }
}