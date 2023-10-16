import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		
		if(a > b) {
			long temp = b; 
			b = a; 
			a = temp; 
		}
		
		if((b-a) > 2) {
			System.out.println(b-a-1);
		}else {
			System.out.println(0);
		}
		
		for(long i=a+1; i<=b-1; i++) {
			System.out.print(i+" ");
		}
		
	}
	
}