import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N; // 날의 수
	static int[] stocks, benefit;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
		StringTokenizer st; 
		
		int T = Integer.parseInt(br.readLine()); 
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine()); 
			stocks = new int[N]; 
			benefit = new int[N]; 
			
			st = new StringTokenizer(br.readLine()); 
			for(int i=0; i<N; i++) {
				stocks[i] = Integer.parseInt(st.nextToken()); 
			}
//			System.out.println(Arrays.toString(stocks));
			
//			for(int today=1; today<N; today++) {
//				for(int past=0; past<today; past++) {
//					if(stocks[today] < stocks[past]) continue;
//					
//					if((stocks[today] - stocks[past]) > benefit[past]) benefit[past] = stocks[today] - stocks[past];
//				}
//			}
//			
//			int sum = Arrays.stream(benefit).sum(); 
//			
//			System.out.println(sum);
			
			int max =stocks[N-1]; 
			long sum = 0L; 
			
			for(int i=N-2; i>=0; i--) {
				if(max <= stocks[i]) {
					// 최대값 갱신
					max = stocks[i]; 
				}else {
					sum += max - stocks[i]; 
				}
			}
			System.out.println(sum);
		} // Test_case End
		
	}

}