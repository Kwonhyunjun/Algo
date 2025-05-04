import java.io.*;
import java.util.*;

public class Main {

	static int N, M, R, res, items[], dist[] ;
	static List<int[]>[] adjList;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		items = new int[N+1];
		for(int i=1; i<=N; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		adjList = new List[N+1];
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[a].add(new int[] {b, w});
			adjList[b].add(new int[] {a, w});
		}
		
		int answer = 0;
		for(int i=1; i<=N; i++) {
			dist = new int[N+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			solve(i);
			
//			System.out.println(Arrays.toString(dist));
			
			int res = 0;
			for(int j=1; j<=N; j++) {
				if(dist[j] <= M) {
					res += items[j];
				}
			}
			answer = Math.max(answer, res);
		}

		System.out.println(answer);
	}
	
	static void solve(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		dist[start] = 0;
		pq.offer(new int[] {start, 0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int n = cur[0];
			int d = cur[1];
			
			if(d != dist[n]) continue;
			
			for(int[] nxt : adjList[n]) {
				if(dist[nxt[0]] <= cur[1] + nxt[1]) continue;
				
				dist[nxt[0]] = cur[1] + nxt[1];
				pq.offer(new int[] {nxt[0], cur[1] + nxt[1]});
			}
		}
		
		
	}

}