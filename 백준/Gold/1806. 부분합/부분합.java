import java.io.*;
import java.util.*; 

/*
 * Try 1. 시간 초과
 * 	문제점 : index의 위치가 바뀔 때 마다 합을 구하면 안됨 -> 누적된 합을 사용해야 함
 */

public class Main {

	static int N, M; 
	static int[] arr; 
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); 
		arr = new int[N]; 
		
		st = new StringTokenizer(br.readLine()); 
		
		for(int i=0;i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}

		int start = 0;
		int end = 0;
		int minLen = Integer.MAX_VALUE;
		int total = arr[0]; 
		
		
		while(true) {
			// 종료 조건
			if(start >= N) break; 
			
//			System.out.printf("start : %d, end : %d, sum : %d \n", start, end, total);
			
			if(total < M) { // 주어진 부분합 보다 작으면
				if(end >= N-1) {
					start++; 
					continue; 
				}
				end++;
				total += arr[end]; 
			}else { // 같거나 크면
				minLen = Math.min(minLen, (end - start)+1); // 구간의 길이를 갱신
//				System.out.printf("update -> %d\n", minLen);
				total -= arr[start]; 
				start++; 
//				end = start+1; 
			}
			
		}
		
		int ans = minLen == Integer.MAX_VALUE ? 0 : minLen; 
		System.out.println(ans); 
		
	}
	
	private static int sum(int start, int end) {
		int sum = 0;
		
		for(int i=start; i<end+1; i++) {
			sum += arr[i];
		}
		
		return sum; 
	}

}