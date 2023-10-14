import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int cnt = 0;
		int sum = 0;
		int min = 101; 
		
		for(int i=0; i<7; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num%2 == 1) {
				sum += num; 
				min = Math.min(min, num);
				cnt++;
			}
		}
		
		if(cnt == 0) {
			System.out.println(-1);
		}else {
			
			System.out.println(sum);
			System.out.println(min);
		}
		
	}
}