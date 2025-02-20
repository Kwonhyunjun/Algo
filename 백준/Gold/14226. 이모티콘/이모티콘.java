import java.io.*;
import java.util.*;

public class Main {

	static int N, v[][]; 
	static class Data{
		int screen, clipboard, cnt;
		
		public Data(int screen, int clipboard, int cnt) {
			this.screen = screen;
			this.clipboard = clipboard; 
			this.cnt = cnt; 
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		v = new int[2001][2001];
		
		for(int i=0; i<2001; i++) {
			Arrays.fill(v[i], Integer.MAX_VALUE);
		}
		
		System.out.println(solve());

	}
	
	static int solve() {
		Queue<Data> q = new ArrayDeque<>();
		
		q.offer(new Data(1, 0, 0)); 
		v[1][0] = 0;
		
		while(!q.isEmpty()) {
			Data cur = q.poll();
//			System.out.println(cur.screen + " " + cur.cnt);
			
			if(cur.screen == N) return cur.cnt;
			if(cur.screen == 0) continue;
			
			int nextCnt = cur.cnt+1;
			
			if(cur.screen < N) {
				// 1번 연산
				if(v[cur.screen][cur.screen] > nextCnt) {
//					System.out.println("1번");
					q.offer(new Data(cur.screen, cur.screen, nextCnt));
					v[cur.screen][cur.screen] = nextCnt;
				}
				// 2번 연산
				if(cur.clipboard != 0 && v[cur.screen + cur.clipboard][cur.clipboard] > nextCnt) {
//					System.out.println("2번");
					q.offer(new Data(cur.screen + cur.clipboard, cur.clipboard, nextCnt));
					v[cur.screen + cur.clipboard][cur.clipboard] = nextCnt; 
				}
			}
			
			if(cur.screen -1 > 0 && v[cur.screen-1][cur.clipboard] > nextCnt) {
//				System.out.println("3번");
				q.offer(new Data(cur.screen -1, cur.clipboard, nextCnt));
				v[cur.screen-1][cur.clipboard] = nextCnt;
			}
			
		}
		
		return -1; 
	}

}