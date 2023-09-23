import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int F, G, S, U, D; // 높이, 현재위치, 목표, 올라가는 칸, 내려가는 칸
	static boolean[] v; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		F = sc.nextInt(); // 높이(가장 높은 층)
		S = sc.nextInt(); // 현재 위치 
		G = sc.nextInt(); // 목표층 
		U = sc.nextInt(); // 올라가는 높이
		D = sc.nextInt(); // 내려가는 높이
		
		v = new boolean[F+1];
	
		bfs(S);			

		
		
	}
	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		
		q.offer(start); 
		v[start] = true; 
		
		int cnt = 0; 
		while(!q.isEmpty()) {
			int size = q.size(); 
			cnt++; 
			
			for(int i=0; i<size; i++) {
				int cur = q.poll();
				
				if(cur == G) {
					System.out.println(cnt-1);
					return;
				}
				
				
				if(cur+U <= F && !v[cur+U]) {
					q.offer(cur+U);
					v[cur+U] = true;
				}
				if(cur-D > 0 && !v[cur-D]) {
					q.offer(cur-D);	
					v[cur-D] = true; 
				}
			}
		}
		System.out.println("use the stairs");
	}

}