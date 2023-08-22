import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N; // 원소의 개수
	static int M; // 연산의 개수
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder(); 

		// 테스트 케이스 수 읽기
		int T = Integer.parseInt(br.readLine());

		// 테스트 케이스 수만큼 반복
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			parents = new int[N + 1];

			for (int i = 1; i < N + 1; i++) {
				parents[i] = i; 
			}
			
			int ans = 0; 
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a, b); 
			}
			
			for(int i =1; i<parents.length;i++) {
				if(i == parents[i]) ans++;
			}
			System.out.printf("#%d %s\n",t ,ans);
		}
	}
	
	private static boolean union(int b, int c) {
		b = find(b); 
		c = find(c); 
		
		if(b == c) return false;
		
		parents[c] = b;
		return true;
	}

	static int find(int a) {
		if(a == parents[a]) return a; 
		
		return parents[a] = find(parents[a]); 
	}
}
