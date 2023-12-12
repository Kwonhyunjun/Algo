import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine(); 
		
		st = new StringTokenizer(str, "-"); // 55, 50+40
		
		int sum = 0; 
		
		String s = st.nextToken();  // 55
//		System.out.println(s);
		StringTokenizer st2 = new StringTokenizer(s, "+"); // 55 
		
		while(st2.hasMoreTokens()) {
			int num = Integer.parseInt(st2.nextToken());
//			System.out.println(num);
			sum += num; 
		}
		
		
		while(st.hasMoreTokens()) { // 50+40 = - 90
			s = st.nextToken(); 
			
			StringTokenizer st3 = new StringTokenizer(s, "+");
			
			int temp = 0; 
			while(st3.hasMoreTokens()) {
				int num = Integer.parseInt(st3.nextToken());
//				System.out.println(num);
				temp += num; 
			}
			
			sum -= temp; 
			
		}
		
		System.out.println(sum);
		
	}
}