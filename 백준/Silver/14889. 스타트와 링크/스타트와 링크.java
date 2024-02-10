import java.io.*;
import java.util.*;

public class Main {
	
	static int N, sum, ans; 
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine()); 
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sum += map[i][j]; 
			}
		}
		
//		System.out.println("sum: "+sum);
		v = new boolean[N]; 
		list = new ArrayList<>();
		ans = Integer.MAX_VALUE; 
		subSet(0); 
	
		System.out.println(ans);
	}
	
	static boolean[] v;
	static List<Integer> list;
	
	static void subSet(int cnt) {
		if(list.size() > N/2) return;
		if(cnt == N) {
			if(list.size() != N/2) return; 
//			System.out.println(list);
			
			int temp = 0; // 현재 팀의 시너지
			
			// 조합
			
			for(int i=0; i<N/2; i++) {
				for(int j=i; j<N/2; j++) {
					int a = list.get(i);
					int b = list.get(j);
//					System.out.println("a : " + a + " b : "+b);
					temp += map[a][b]; 
					temp += map[b][a]; 
//					System.out.println(temp);
				}
			}
			
			List<Integer> anotherTeam = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				if(list.contains(i)) continue; 
				anotherTeam.add(i); 
			}
			
//			System.out.println(anotherTeam);
			
			int temp2 = 0;
			
			for(int i=0; i<N/2; i++) {
				for(int j=i; j<N/2; j++) {
					int a = anotherTeam.get(i);
					int b = anotherTeam.get(j);
//					System.out.println("a : " + a + " b : "+b);
					temp2 += map[a][b]; 
					temp2 += map[b][a]; 
//					System.out.println(temp2);
				}
			}
			
//			System.out.println("temp: " +temp);
//			System.out.println("temp2: " +temp2);
			
			int diff = Math.abs(temp2-temp);
//			System.out.println(diff);
			
			ans = Math.min(ans, diff); 
			
			return; 
		}
		
		list.add(cnt); 
		subSet(cnt+1);
		
		list.remove(list.size()-1); 
		subSet(cnt+1);
	}

}