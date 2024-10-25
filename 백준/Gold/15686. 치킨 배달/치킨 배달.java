import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, map[][], answer; 
	static boolean[][] v, selected; 
	static ArrayList<int[]> chicken, homes; 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // map의 크기
		M = Integer.parseInt(st.nextToken()); // 골라야하는 치킨 수
		answer = Integer.MAX_VALUE;
		
		map = new int[N][N];
		chicken = new ArrayList<>();
		homes = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
				if(map[i][j] == 1) {
					homes.add(new int[] {i, j});
				}else if(map[i][j] == 2) {
					chicken.add(new int[] {i, j});
				}
			}
		}
		// Input End
		
		for(int i=1; i<=M; i++) {
//			System.out.println("M : " + i);
			choose(0, 0, i);
		} 
		
		System.out.println(answer);

	}
	
	static ArrayList<int[]> list = new ArrayList<>(); 
	static void choose(int idx, int cnt, int m) { // 현재 고려하는 치킨집, 현재까지 고른 치킨집 수
		if(cnt == m) {
			int temp = 0; 
			for(int[] home : homes) {
				int res = Integer.MAX_VALUE; 
				for(int[] s : list) {
					res = Math.min(res, Math.abs(s[0]-home[0]) + Math.abs(s[1]-home[1])); 
				}
				temp += res;
			}
			answer = Math.min(temp, answer);
			return; 
		}
		
		if(idx >= chicken.size()) return; 
		
		int[] cur = chicken.get(idx);
		list.add(cur); 
		choose(idx+1, cnt+1, m);
		list.remove(list.size()-1); 
		
		choose(idx+1, cnt, m); 
		
	}
}