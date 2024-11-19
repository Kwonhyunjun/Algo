import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, B, total, mapBlock, map[][]; 
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		map = new int[N][M]; 
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -(o1 - o2)); 
		
		int minHeight = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				mapBlock += map[i][j];
				minHeight = Math.min(minHeight, map[i][j]);
			}
		}
		
		total = B + mapBlock; 
		
		
		int maxHeight = total / (N * M);
	
		int time = Integer.MAX_VALUE;
		int height = 0;
		
		for(int i=maxHeight; i>= 0; i--) {
			
			int curTime = 0;
			
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					int diff = Math.abs(map[n][m] - i); // 현재 높이와 기준 높이의 차이
					if(map[n][m] > i) {
						curTime += diff * 2; 
					}else {
						curTime += diff; 
					}
				}
				
			}
						
			if(curTime >= time) break; 
			time = curTime;
			height = i; 
			
		}
		
		System.out.println(time + " " + height);
		
		
	}

}