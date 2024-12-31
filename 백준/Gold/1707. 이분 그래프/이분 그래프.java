import java.io.*;
import java.util.*;

public class Main { 
	
	static final int BLUE = 1;
	static final int RED = -1;

	static int T, V, E, color[];
	static ArrayList<Integer>[] adjList;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList[V+1];
			
			for(int i=1; i<=V; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				adjList[a].add(b);
				adjList[b].add(a);
			}
			
			color = new int[V+1]; 
			
			boolean flag = true;
			for(int i=1; i<=V; i++) {
				if(color[i] != 0) continue; 
//				System.out.println(i);
				
				if(!bfs(i)) {
					flag = false;
					break;
				}
//				System.out.println(Arrays.toString(color));
				
			}
			
			String answer = (flag) ? "YES" : "NO"; 
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static boolean bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		
		q.offer(start);
		color[start] = BLUE;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			int curColor = color[cur];
//			System.out.println(cur);
			
			for(int next : adjList[cur]) {
				int nextColor = (curColor == BLUE) ? RED : BLUE;
				
//				System.out.println(next + " " + (color[next] == curColor));
				
				if(color[next] == curColor) return false;
				if(color[next] != 0) continue; 
				
				color[next] = nextColor;
				q.offer(next);
			}
		}
		return true; 
	}

}