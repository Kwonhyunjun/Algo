import java.util.*; 

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A); 
        // System.out.println(Arrays.toString(A));
        Arrays.sort(B);
        // System.out.println(Arrays.toString(B));
        
        for(int i=0; i<A.length; i++){
            int n1 = A[i]; 
            int n2 = B[B.length - i-1];
            // System.out.println(n1 + " " + n2); 
            answer += (n1 * n2); 
            // System.out.println(answer); 
        }
        
        return answer;
    }
}