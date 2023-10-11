import java.util.*;

class Solution {
   public static void main(String[] args) throws Exception {
		System.out.println(Arrays.toString(solution(24,24)));
	}
	
	public static int[] solution(int brown, int yellow) {
        for(int i=1; i<5000; i++) {
			for(int j=1; j<5000; j++) {
				if(i < j) break; 
				if(i * j == brown + yellow) {
					int sizeB = i * 2 + j * 2 - 4; 
					if(brown == sizeB) {
						return new int[] {i, j};
					}
				}
			}
		}
		return null;
    }
}