import java.io.*;
import java.util.*; 

public class Main {
	
	static int N, M, dist[], pre[], start, end;
	static ArrayList<int[]>[] adjList; 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 도시(정점)개수
		M = Integer.parseInt(br.readLine()); // 버스(간선)개수
		
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		pre = new int[N+1];
		adjList = new ArrayList[N+1];
		
		for(int i=1; i<N+1; i++) {
			adjList[i] = new ArrayList();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
//			System.out.printf("%d, %d, %d\n", from, to, weight);
			
			adjList[from].add(new int[] {to, weight});
		}
		
		st = new StringTokenizer(br.readLine()); 
		start = Integer.parseInt(st.nextToken()); 
		end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		
//		System.out.println(Arrays.toString(dist));
//		System.out.println(Arrays.toString(pre));
		
		List<Integer> path = new ArrayList<>(); 
		
		int position = end; 
		while(true) {
			path.add(position);
			if(position == start) break;
			position = pre[position]; 
		}
		
//		System.out.println(path);
		StringBuilder sb = new StringBuilder(); 
		
		sb.append(dist[end]).append("\n"); 
		sb.append(path.size()).append("\n"); 
		
		for(int i=path.size()-1; i>=0; i--) {
			sb.append(path.get(i)).append(" "); 
		}
		
		System.out.println(sb);
	}

	private static void dijkstra(int s) {
		// 1. PQ 선언
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		}); 
		
		// 2. 시작점 넣기
		pq.offer(new int[] {s, 0}); 
		dist[s] = 0; 
		
		// 3. 순회
		while(!pq.isEmpty()) {
			// 3-1. 현재 정점 꺼내기
			int[] cur = pq.poll(); 
			int curP = cur[0]; 
			int curW = cur[1];
			
			// 3-2.
			if(dist[curP] != curW) continue;
			
			// 3-3.
			for(int i=0; i<adjList[curP].size(); i++) {
				int[] n = adjList[curP].get(i); 
				int nP = n[0];
				int nW = n[1]; 
				
				// 현재 경로의 비용이 더 높다면 패스
				if(dist[nP] <= curW + nW) continue;
				
				dist[nP] = curW + nW;
				pq.offer(new int[] {nP, curW + nW});
				pre[nP] = curP; 
			}
			
		}
		
	}


}