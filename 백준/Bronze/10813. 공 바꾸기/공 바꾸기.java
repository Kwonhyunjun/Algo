import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] buckets;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		buckets = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			buckets[i] = i; 
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int tmp = buckets[a]; 
			buckets[a] = buckets[b];
			buckets[b] = tmp;
		}
		
		for(int i=1; i<N+1; i++) {
			System.out.print(buckets[i] + " ");
		}
	}

}