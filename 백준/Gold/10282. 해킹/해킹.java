import java.io.*;
import java.util.*;

public class Main {

	static int N, D, C;
	static List<int[]>[] adjList; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			
			adjList = new List[N+1];
			for(int i=1; i<N+1; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			for(int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				adjList[b].add(new int[] {a, s});
			}
			
			solve(C); 
		}
	}
	
	static void solve(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		boolean[] v = new boolean[N+1];
		HashSet<Integer> set = new HashSet<>();
		
		pq.offer(new int[] {start, 0});
		v[start] = true;
		
		int lastTime = 0;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
//			System.out.printf("cur -> %d %d \n", cur[0], cur[1]);
			if(!set.contains(cur[0])){
				lastTime = cur[1];
				set.add(cur[0]);
				
				for(int[] nxt : adjList[cur[0]]) {
//				if(v[nxt[0]]) continue;
//				v[nxt[0]] = true;
					
					pq.offer(new int[] {nxt[0], cur[1] + nxt[1]});
//					System.out.printf("nxt -> %d %d \n", nxt[0], cur[1] + nxt[1]);
					
				}
			}
			
		}
		
		System.out.println(set.size() + " " + lastTime); 
	}

}