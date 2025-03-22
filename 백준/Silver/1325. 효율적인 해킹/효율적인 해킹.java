import java.io.*;
import java.util.*;


public class Main {
	
	static int N, M, memo[], max; 
	static List<Integer>[] adjList;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new List[N+1];
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		memo = new int[N+1];
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjList[a].add(b);
		}
		
		max = Integer.MIN_VALUE;
		
		for(int i=1; i<=N; i++) {
			v = new boolean[N+1];
			v[i] = true;
			solve(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			if(memo[i] == max) {
				sb.append(i).append(" ");
			}
		}
		
//		System.out.println(max + " " + Arrays.toString(memo));
		System.out.println(sb);
	}
	
	static void solve(int cur) {
		
		memo[cur]++;
		max = Math.max(max, memo[cur]);
		
		for(int nxt : adjList[cur]) {
			if(v[nxt]) continue;
			v[nxt] = true;
			solve(nxt);
		}
	}

}