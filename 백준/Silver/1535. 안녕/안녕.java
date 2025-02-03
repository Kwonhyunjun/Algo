import java.io.*;
import java.util.*;

public class Main {

	static int N, peoples[][], answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine());
		peoples = new int[N][2]; 
		
		for(int i=0; i<2; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				peoples[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 100, 0);
		
		System.out.println(answer);

	}
	
	static void dfs(int idx, int hp, int happy) {
		if(hp <= 0) return; 
		
		if(idx == N) {
//			System.out.printf("%d %d %d\n", idx, hp, happy);
			answer = Math.max(happy, answer);
			return; 
		}
		dfs(idx+1, hp-peoples[idx][0], happy+peoples[idx][1]);
		dfs(idx+1, hp, happy);
	}

}