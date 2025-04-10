import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); 
		
		int[][] lines = new int[6][2];
		
		int maxWidth = 0; 
		int maxHeight = 0;
		int idx = 0;
		
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			
			int dir = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			lines[i] = new int[] {dir, num};
			
			if(dir < 3) {
				if(maxWidth < num) {
					maxWidth = Math.max(num, maxWidth);
					idx = i;
				}				
			}else {
				maxHeight = Math.max(num, maxHeight);
			}
		}
		
		int smallWidth = 0;
		int smallHeight = 0;
	
		
//		System.out.println(idx);
		
		boolean isLeft = true;
		
		int leftIdx = (idx-1) < 0 ? 5 : idx-1;
		int rightIdx = (idx+1) > 5 ? 0 : idx+1;
		
		if(lines[leftIdx][1] > lines[rightIdx][1]) {
			isLeft = false;
			smallWidth = lines[rightIdx][1];
		}else {
			smallWidth = lines[leftIdx][1];
		}
		
		if(isLeft) {
			smallHeight = lines[(leftIdx-1) < 0 ? 5 : leftIdx-1][1];
		}else {
			smallHeight = lines[(rightIdx+1) > 5 ? 0 : rightIdx+1][1];
		}
//		
//		System.out.println((maxHeight * maxWidth));
//		System.out.println(smallHeight + " " +  (maxWidth-smallWidth));
//		System.out.println((smallHeight * (maxHeight-smallWidth)));
//		System.out.println(maxWidth + " " + maxHeight);
		int answer = ((maxHeight * maxWidth) - (smallHeight * (maxHeight-smallWidth))) * N;
		System.out.println(answer);
	}

}