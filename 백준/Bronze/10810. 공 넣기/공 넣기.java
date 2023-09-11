import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M; // N 바구니 개수, M 공 넣는 횟수
	static int[] buckets; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken());
		buckets = new int[N+1]; 
		
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			for(int j = from; j<= to ; j++) {
				buckets[j] = num; 
			}
		}
		
		for(int i=1; i<=N ; i++) {
			System.out.print(buckets[i] + " ");
		}
	}

}