import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] parents;
	static List<Integer> eList; 

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 사람 수
		M = Integer.parseInt(st.nextToken()); // 파티 수

		make();

		st = new StringTokenizer(br.readLine());

		int cnt = Integer.parseInt(st.nextToken());
		eList = new ArrayList<>();

		if (cnt == 0) { // 진실을 아는 사람이 없을 때
			System.out.println(M);
			return;
			
		} else {
			
			// 진실을 아는 사람은 0과 연결
			for(int i=0; i<cnt; i++) {
				eList.add(Integer.parseInt(st.nextToken())); 
			}
		}
		
		List<Integer>[] partyList = new ArrayList[M];
		for(int i=0; i<M; i++) {
			partyList[i] = new ArrayList<>(); 
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			int pn = Integer.parseInt(st.nextToken());
			
			int x = Integer.parseInt(st.nextToken());
			partyList[i].add(x); 
			
			for(int j=1; j<pn; j++) {
				int y = Integer.parseInt(st.nextToken());
				union(x,y); 
				partyList[i].add(y);
			}
		}
		
//		System.out.println(Arrays.toString(parents));
		
		int c = 0;
		
		for(int i=0; i<M; i++) { // 각 파티마다
			boolean flag = true; 
			for(int num : partyList[i]) {
				if(eList.contains(find(parents[num]))) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
//				System.out.printf("%d는 거짓말 쳐도 되는 파티\n", i);
				c ++;
			}
		}
		
		System.out.println(c);
		

	}

	private static void make() {
		parents = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a == parents[a]) return a; 
		
		return parents[a] = find(parents[a]); 
		
	}
	
	private static void union(int a, int b) {
		int ra = find(a);
		int rb = find(b); 
		
		if(eList.contains(rb)) {
			int tmp = ra; 
			ra = rb; 
			rb = tmp; 
		}
		
		parents[rb] = ra; 
		
	}

}