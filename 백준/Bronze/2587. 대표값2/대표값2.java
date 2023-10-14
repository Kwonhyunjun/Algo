import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int sum = 0;
		int mid = 0; 
		int[] arr = new int[5]; 
		
		for(int i=0; i<5; i++) {
			int num = Integer.parseInt(br.readLine());
			
			sum += num; 
			
			arr[i] = num;
			
		}
		
			Arrays.sort(arr);
			System.out.println(sum/5);
			System.out.println(arr[2]);
		
	}
}