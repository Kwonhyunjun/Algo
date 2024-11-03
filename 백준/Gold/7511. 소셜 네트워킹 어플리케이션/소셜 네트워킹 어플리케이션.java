import java.io.*;
import java.util.*; 

public class Main {
	
	static int T, N, K, M, arr[]; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder(); 
		
		T = Integer.parseInt(br.readLine()); 
		
		for(int t=0; t<T; t++) {
			
			sb.append("Scenario ").append(t+1).append(":").append("\n"); 
			
			N = Integer.parseInt(br.readLine()); // 유저의 수
			
			arr = new int[N]; 
			Arrays.fill(arr, -1);
			
			K = Integer.parseInt(br.readLine()); // 친구 관계의 수
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				
				union(n1, n2); 
//				sb.append(Arrays.toString(arr)).append("\n");
			}
			
			M = Integer.parseInt(br.readLine()); // 질문의 수
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine()); 
				
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				
				int res = (find(n1) == find(n2)) ? 1 : 0; 
				
				sb.append(res).append("\n"); 
			}
			
			sb.append("\n"); 
			
		}
		
		System.out.println(sb);

	}
	
	static int find(int x) {
		if(arr[x] < 0) {
			return x; 
		}
		
		return arr[x] = find(arr[x]); 
		
	}
	
	static boolean union(int u, int v) {
		// 1. 각 원소의 부모 찾기
		int parent1 = find(u);
		int parent2 = find(v); 
		
		// 2. 같은 집합이라면 return false 
		if(parent1 == parent2) return false;
		
		
		// 다른 집합일 경우
		// Rank를 활용해 Union (앞쪽에 있는 것이 랭크가 더 높게 설정)
		
		if(arr[parent1] > arr[parent2]) {
			// parent2의 높이가 더 큰 상황
			int temp = u; 
			u = v; 
			v = temp; 
		}
		
		if(arr[parent1] == arr[parent2]) {
			arr[parent1]--; 
		}
		
		// 더 높은 rank의 트리의 루트에 더 낮은 rank의 트리를 붙여야 한다.
		arr[parent2] = parent1; 
		return true; 
	}

}