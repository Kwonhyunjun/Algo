import java.io.*;
import java.util.*;

public class Main {

	static int n, m, dist[][];
	static ArrayList<Data>[] adjList; 
	
	static class Data{
		int n; 
		int w; 
		
		public Data(int n, int w) {
			this.n = n; 
			this.w = w; 
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine()); 
		m = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList[n+1]; 
		dist = new int[n+1][n+1]; 
		for(int i=1; i<n+1; i++) {
			adjList[i] = new ArrayList(); 
			Arrays.fill(dist[i], 0x3f3f3f3f); // int overflow가 나지 않겠끔
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			dist[from][to] = Math.min(w, dist[from][to]); 
			adjList[from].add(new Data(to, w));
		}
		
		for(int i=1; i<n+1; i++) {
			dist[i][i] = 0;  
		}
		
//		for(int i=1; i<n+1; i++) {
//			System.out.println(Arrays.toString(dist[i]));
//		}
//		System.out.println();
		
		// 플로이드 워샬
//		for(int i=1; i<n+1; i++) {
//			for(int j=1; j<n+1; j++) {
//				for(int k=1; k<n+1; k++) {
//					dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]); 
//				}
//			}
//		}
		// k, i, j가 국룰
		for(int k=1; k<n+1; k++) {
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]); 
				}
			}
		}
		
		
		
//		for(int i=1; i<n+1; i++) {
//			System.out.println(Arrays.toString(dist[i]));
//		}
		
		StringBuilder sb = new StringBuilder(); 
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				dist[i][j] = dist[i][j] == 0x3f3f3f3f ? 0 : dist[i][j]; 
				sb.append(dist[i][j]).append(" "); 
			}
			sb.append("\n"); 
		}
		
		System.out.println(sb);
	}
}