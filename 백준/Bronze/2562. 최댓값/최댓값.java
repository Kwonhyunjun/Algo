import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		
		int[] arr = new int[9];
		int max = 0; 
		
		for(int i=0; i<9; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
			max = Math.max(num, max);
		}
		
		int cnt = 1;
		for(int num : arr) {
			if(num == max) break; 
			cnt++; 
		}
		
		System.out.println(max);
		System.out.println(cnt);

	}
	
}