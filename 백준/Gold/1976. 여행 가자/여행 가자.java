import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, parent[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 도시의 수
		M = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시들의 수
		
		parent = new int[N+1];
		Arrays.fill(parent, -1);
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=1; j<=N; j++) {
				boolean isConnected = (st.nextToken().equals("1")) ? true : false; 
				
				if(isConnected) union(i, j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		boolean can = true;
		int common = find(Integer.parseInt(st.nextToken()));
		for(int i=1; i<M; i++) {
			if(find(Integer.parseInt(st.nextToken())) != common) {
				can = false;
				break; 
			}
		}
		
		System.out.println((can) ? "YES" : "NO");

	}
	
	static int find(int x) {
		if(parent[x] == -1) 
			return x; 
		
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int x, int y) {
		int parentX = find(x);
		int parentY = find(y);
		
		if(parentX == parentY) return false;
		
		parent[parentX] = parentY;
		return true; 
		
	}

}