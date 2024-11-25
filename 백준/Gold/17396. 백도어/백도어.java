import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static long[] dist;
	static boolean visible[], v[];
	static ArrayList<int[]>[] adjList; 
	

    static class Node {
        int idx;
        long cost;

        public Node(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visible = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			visible[i] = (st.nextToken().equals("0")) ? false : true;
		}
		
//		System.out.println(Arrays.toString(visible));
		
		adjList = new ArrayList[N];
		
		for(int i=0; i<N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			adjList[a].add(new int[] {b, t});
			adjList[b].add(new int[] {a, t});
		}
		
		dist = new long[N];
		Arrays.fill(dist, Long.MAX_VALUE);
//		System.out.println();
//		System.out.println(dist[1]);
		
		v = new boolean[N];
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.cost,o2.cost));
		
		pq.add(new Node(0, 0)); 
		v[0] = true;
		dist[0] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.idx == N-1) continue;
			if(dist[cur.idx] < cur.cost) continue; 
			
			for(int[] next : adjList[cur.idx]) {
				
				int np = next[0];
				int nw = next[1];
				
				if(visible[np] && np != N-1) continue; 
				
				if(dist[np] > cur.cost + nw) {
					dist[np] = cur.cost + nw;
					pq.offer(new Node(np, cur.cost+ nw));
				}
			}
		}
		
		long answer = (dist[N-1] == Long.MAX_VALUE) ? -1 : dist[N-1];
		
		System.out.println(answer);
	}

}