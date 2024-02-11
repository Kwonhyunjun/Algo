import java.io.*;
import java.util.*;

public class Main {

	static int T, N; 
	static int[] input, v;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		T = Integer.parseInt(br.readLine()); 
		
		for(int t=0; t<T; t++) {
			
			N = Integer.parseInt(br.readLine()); 
			input = new int[N+1]; 
			st = new StringTokenizer(br.readLine()); 
			
			for(int i=1; i<N+1; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			int ans = 0;
			v = new int[N+1];
			
			for(int i=1; i<=N; i++) { // 모든 원소 방문
				if(v[i] == 0) bfs(i); // 아직 방문하지 않은 노드라면 탐색 ㄱㄱ
			}
			
			for(int i=1; i<=N; i++) {
				if(v[i] != -1) ans++; 
			}
			
			System.out.println(ans);
			
		}// t 

	}
	
	static void bfs(int x) {
		int cur = x; // x는 시작 원소, cur은 현재 탐색 위치
		
		while(true) {
			v[cur] = x; // 현재 탐색 위치노드에 시작노드 마킹
			cur = input[cur]; // 다음으로 넘어가려 함 
			
			// 이번 방문에서 지나간 학생에 도달했을 경우 -> 사이클 발생
			if(v[cur] == x) {
				while(v[cur] != -1) {
					v[cur] = -1; // 사이클 마킹
					cur = input[cur]; // 다음으로 이동
				}
				return;
			}
			
			// 이전 방문에서 지나간 학생에 도달 -> 사이클 실패
			else if(v[cur] != 0) return; 
		}
	}

}