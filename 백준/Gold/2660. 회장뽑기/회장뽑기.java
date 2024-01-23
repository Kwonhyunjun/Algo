import java.io.*;
import java.util.*;

public class Main {

	static int N, res[];
	static int[][] adjMatrix;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		adjMatrix = new int[N + 1][N + 1];
		res = new int[N + 1];

		while (true) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			if (from == -1)
				break;

			adjMatrix[from][to] = 1;
			adjMatrix[to][from] = 1;
		}
		
//		for(int[] a : adjMatrix) {
//			System.out.println(Arrays.toString(a));
//		}
		


		int min = Integer.MAX_VALUE; 

		for (int i = 1; i < N + 1; i++) {
			v = new boolean[N + 1];
//			System.out.println("결과 : "+bfs(i));
			int a = bfs(i)-1; 
			res[i] = a;
			min = Math.min(min, a); 
		}
		
		int cnt =0; 
		String s = ""; 
		for(int i=1; i<N+1; i++) {
			if(res[i] == min) {
				cnt++; 
				s += i +" "; 
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(min).append(" ").append(cnt).append("\n").append(s); 
		System.out.println(sb);
	}

	static boolean[] v;

	static int bfs(int start) {
//		System.out.println(start);
		Queue<Integer> q = new ArrayDeque<>();

		q.offer(start);
		v[start] = true;

		int depth = 0, cnt = 0;

		while (!q.isEmpty()) {
//			System.out.println("detpth : "+depth+" "+ q);
			int size = q.size();
//			if(cnt == N-1) break;
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
//				System.out.println(cur);
				
				for (int j = 1; j < N + 1; j++) {
//					System.out.println(cur +" " + j+ " " +adjMatrix[cur][j]);
					if(adjMatrix[cur][j] != 1) continue;
					if(v[j]) continue;
					
					q.offer(j);
					v[j] = true;
					cnt++; 
				}

			}
			depth++;
			
		}
		  
//		System.out.println(Arrays.toString(v));
		return depth;
	}

}