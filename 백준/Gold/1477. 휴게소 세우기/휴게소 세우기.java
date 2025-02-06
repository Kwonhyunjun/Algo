import java.io.*;
import java.util.*;

public class Main {

	static int N, M, L, rest[], dist[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		rest = new int[N];
		dist = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			rest[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(rest);
		
//		System.out.println(Arrays.toString(rest));
		
		int prev = 0; 
		for(int i=0; i<N; i++) {
			dist[i] = rest[i] - prev;
			prev = rest[i];
		}
		
		dist[N] = L - prev; 
		
//		System.out.println(Arrays.toString(dist));
		
		int left = 0; 
		int right = 0;
		
		for(int num : dist) {
			right = Math.max(num, right);
		}
		
		
		int answer = L;
		
		while(left <= right) {
			int mid = (left + right) / 2; 
			
//			System.out.println("mid : " + mid);
			
			int res = isPossible(mid);
			
			if(res == -1) {
				// 최댓값을 늘려야 함
				left = mid + 1; 
//			}else if(res == 1) {
//				// 최댓값을 줄여야 함 
//				right = mid - 1; 
//				answer = Math.min(answer, mid);
			}else {
				right = mid - 1; 
				answer = Math.min(answer, mid);
			}
		}
		
		System.out.println(answer);

	}
	
	static int isPossible(int mid) {
		int cnt = M; 
		
		for(int i=0; i<=N; i++) {
			int cur = dist[i];
			// 해당 구간이 설정한 거리보다 짧다면 넘어감
			if(cur <= mid) continue;
			
			while(cur > mid) { // 현재 거리가 설정한 거리보다 크다면
				if(cnt == 0) return -1; // 휴게소가 부족하다면
				
				cur -= mid; 
				cnt--; 
			}
		}
		
		
		
		return (cnt > 0) ? 1 : 0; 
		
	}

}