import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static boolean[][] v; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		v = new boolean[1000001][3]; 
		solve(); 
	}
	
	static void solve() {
		PriorityQueue<Data> pq = new PriorityQueue<Data>();
		pq.offer(new Data(N, 0)); 
		for(int i=0; i<3; i++) {
			v[N][i] = true; 
		}
		
		while(!pq.isEmpty()) {
			Data cur = pq.poll(); 
			if(cur.pos == K) {
				System.out.println(cur.min);
				break;
			}
			
			// 순간이동 *2
			if(cur.pos <= 100_000  && !v[cur.pos * 2][0]) {
				pq.offer(new Data(cur.pos * 2 , cur.min)); 
				v[cur.pos * 2][0] = true; 
			}
			
			// left -1
			if(cur.pos-1 > -1 && !v[cur.pos-1][1] && cur.pos <= 100_000) {
				pq.offer(new Data(cur.pos-1, cur.min+1)); 
				v[cur.pos-1][1] = true; 
			}
			// right +1
			if(cur.pos+1 <= 100_000 && !v[cur.pos+1][2]) {
				pq.offer(new Data(cur.pos+1, cur.min+1)); 
				v[cur.pos+1][2] = true; 
			}
			
			
		}
	}
	
	static class Data implements Comparable<Data>{
		int pos; 
		int min;
		
		public Data(int pos, int min) {
			super();
			this.pos = pos;
			this.min = min;
		}

		
		@Override
		public String toString() {
			return "Data [pos=" + pos + ", min=" + min + "]";
		}


		@Override
		public int compareTo(Main.Data o) {
			// TODO Auto-generated method stub
			return this.min - o.min;
		} 
	}
}