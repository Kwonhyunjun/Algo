import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		N = Integer.parseInt(br.readLine()); 
		
		if(N<60) {
			System.out.println("F");
		}else if(N<70) {
			System.out.println("D");
		}else if(N<80) {
			System.out.println("C");
		}else if(N<90) {
			System.out.println("B");
		}else {
			System.out.println("A");
		}
	}


}