import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, degree[], target;
	static List<Integer>[] adjList;
	static boolean[] v; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		v = new boolean[N+1];
		
		degree = new int[N+1]; 
		adjList = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			adjList[i] = new ArrayList();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjList[b].add(a);
			degree[b]++;
		}
		
		target = Integer.parseInt(br.readLine());
		
		System.out.println(solve(target));
	}
	
	static int solve(int target) {
		int res = 0; 
		
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(target);
		v[target] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
//			System.out.println(cur);
			res++; 
			
			for(int nxt : adjList[cur]) {
				if(v[nxt]) continue;
				q.offer(nxt);
				v[nxt] = true; 
			}
		}
		
		return res-1;
		
	}

}