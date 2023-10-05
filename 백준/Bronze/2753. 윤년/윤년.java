import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		int ans = 0;
		if (N % 4 == 0 && !(N % 100 == 0)) {
				ans = 1;
		}else if(N%400 == 0){
			ans =1; 
		}
		System.out.println(ans);
	}

}