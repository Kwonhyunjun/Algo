import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R; 
	static ArrayList<Integer>[] adjList;
	static boolean[] v; 
	static int[] ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N+1]; 
		v = new boolean[N+1]; 
		ans = new int[N+1];
		for(int i=0; i<N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		for(int i=0; i<N+1; i++) {
			Collections.sort(adjList[i], Comparator.reverseOrder());
		}
		
//		for(ArrayList a : adjList) {
//			System.out.println(a);
//		}
		
		bfs(R);
		for(int i = 1; i<N+1; i++) {
			System.out.println(ans[i]);
		}
	}

	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start); 
		v[start] = true;
		int cnt = 0; 
		
		while(!q.isEmpty()){
			int cur = q.poll();
			cnt++;
			ans[cur] = cnt;
			
			for(int i=0, size = adjList[cur].size(); i<size; i++) {
				if(v[adjList[cur].get(i)]) continue;
				q.offer(adjList[cur].get(i));
				v[adjList[cur].get(i)] = true;
			}
		}
	}
	

}