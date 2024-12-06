import java.io.*;
import java.util.*;

public class Main {

	static int N, M, k, fee[], parent[]; 
	static boolean v[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		fee = new int[N+1];
		parent = new int[N+1];
		Arrays.fill(parent, -1);
		v = new boolean[N+1]; 
		
		st = new StringTokenizer(br.readLine()); 
		for(int i=1; i<=N; i++) {
			fee[i] = Integer.parseInt(st.nextToken());
		}
		
		// 친구 연결
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a, b);
		}
		
//		System.out.println(Arrays.toString(parent));
		
		HashMap<Integer, Integer> minPrice = new HashMap<>();
		
		for(int i=1; i<=N; i++) {
			int p = find(i);
			
//			System.out.printf("i : %d / parent : %d\n", i, p);
			
			if(minPrice.containsKey(p)) {
				minPrice.put(p, Math.min(fee[i], minPrice.get(p)));
			}else {
				minPrice.put(p, fee[i]);
			}
		}
		
		int total = 0;
		for(int value : minPrice.values()) {
//			System.out.println(value);
			total += value;
		}
		String answer = (k < total) ? "Oh no" : String.valueOf(total);
		System.out.println(answer); 

	}
	
	static int find(int a) {
		if(parent[a] == -1) {
			return a;
		}
		
		return parent[a] = find(parent[a]);
	}
	
	static boolean union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		
		if(parentA == parentB) return false;
		
		if(parentA < parentB) {
			int temp = parentA; 
			parentA = parentB; 
			parentB = temp; 
		}
		
		parent[parentA] = parentB;
		return true;
	}

}