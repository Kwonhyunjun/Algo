import java.io.*;
import java.util.*;

public class Main {

	static int N, map[][], dist[][];
	
	static class Data implements Comparable<Data>{
		int r;
		int c;
		int w; 
		
		public Data(int r, int c, int w) {
			this.r = r;
			this.c = c; 
			this.w = w;
		}
		
		@Override
		public int compareTo(Data o) {
			return this.w - o.w; 
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st; 
		
		int cnt = 1; 
		while(true) { 
			N = Integer.parseInt(br.readLine()); 
			if(N == 0) break;
			
			map = new int [N][N];
			dist = new int[N][N]; 
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()); 
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); 
					dist[i][j] = Integer.MAX_VALUE; 
				}
			}
			
			int dist = solve(); 
			
			sb.append("Problem ").append(cnt).append(": ").append(dist).append("\n"); 
			cnt++; 
		}// while
		System.out.println(sb);
	}
	
	
	static int[] dr = {-1, 0, 1, 0}; 
	static int[] dc = {0, 1, 0, -1}; 
	static int solve() {
		PriorityQueue<Data> pq = new PriorityQueue<>(); 
		
		pq.offer(new Data(0, 0, map[0][0])); 
		dist[0][0] = map[0][0];
		
		while(!pq.isEmpty()) {
			Data cur = pq.poll();
			
			if(dist[cur.r][cur.c] != cur.w) continue;
			
			for(int d=0; d<4; d++) {
				int nextR = cur.r + dr[d];
				int nextC = cur.c + dc[d]; 
				
				if(nextR < 0 || nextC < 0 || nextR >= N || nextC >= N) continue; 
				
				if(dist[nextR][nextC] <= cur.w + map[nextR][nextC]) continue; 
				
				pq.offer(new Data(nextR, nextC, cur.w + map[nextR][nextC])); 
				dist[nextR][nextC] = cur.w + map[nextR][nextC];
				
			}
		}
		
		return dist[N-1][N-1]; 
	}
}