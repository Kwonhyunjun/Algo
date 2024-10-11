import java.io.*;
import java.util.*;

public class Main {
	
	static int N, C, homes[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 도현이네 집
		C = Integer.parseInt(st.nextToken()); // 공유기의 개수
		
		homes = new int[N]; 
		
		for(int i=0; i<N; i++) {
			homes[i] = Integer.parseInt(br.readLine()); 
		}
		
		Arrays.sort(homes);
		
		int left = 1; 
		int right = homes[N-1]; 
		int answer = Integer.MIN_VALUE; 
		
		while(left <= right) {
			int mid = left + (right - left) / 2; 
			if(isPossible(mid)) {
				left = mid + 1; 
				answer = Math.max(answer, mid); 
			}else {
				right = mid -1; 
			}
		}
		
		System.out.println(answer);

	}
	
	static boolean isPossible(int mid) {
		int cnt = C-1; 
		int prev = homes[0]; 
		
		for(int i=1; i<N; i++) {
			if(cnt < 0) break;
			if(Math.abs(homes[i] - prev) >= mid) {
				cnt--; 
				prev = homes[i];
			}
		}
		
		return cnt <= 0; 
	}

}