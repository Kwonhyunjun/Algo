import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, arr[][];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[10][10];
		
		for(int i=0; i<10; i++) {
			Arrays.fill(arr[i], Integer.MAX_VALUE);
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			map.put(start, end);
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			map.put(start, end);
		}
		
		arr[0][0] = 0;
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(0);
		
//		StringBuilder sb = new StringBuilder();
		
		while(!q.isEmpty()) {
			int cur = q.poll();
//			sb.append("cur : ").append(cur).append("\n"); 
			int curCnt = arr[cur/10][cur%10];
			
			for(int i=1; i<=6; i++) {
				int next = cur + i;
				if(next >= 100) continue; 
				int nextCnt = arr[next/10][next%10]; 
				
				if(curCnt + 1 < nextCnt) {
					// 다음 주사위 갱신
					arr[next/10][next%10] = curCnt + 1;
					
					if(map.containsKey(next)) {
						int move = map.get(next);
//						sb.append(next).append(" ").append(move).append("\n");
						if(curCnt + 1 < arr[move/10][move%10]) {
							arr[move/10][move%10] = curCnt + 1;
							q.offer(move); 
						}
					}else {
						q.offer(next);
					}
				}
			}
			
//			for(int i=0; i<10; i++) {
//				for(int j=0; j<10; j++) {
//					if(arr[i][j] == Integer.MAX_VALUE) {
//						sb.append("X").append(" ");
//					}else {
//						sb.append(arr[i][j]).append(" "); 
//					}
//				}
//				sb.append("\n");
//			}
//			sb.append("\n");
		}
		
//		System.out.println(sb);
		System.out.println(arr[9][9]);

	}

}