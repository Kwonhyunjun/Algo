import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st; 
		
		int N = Integer.parseInt(br.readLine());
		
		HashSet<String> set = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			String name = st.nextToken();
			String log = st.nextToken();
			
			if("enter".equals(log)) {
				set.add(name); 
			}else {
				set.remove(name); 
			}
		}
		
//		String[] arr = (String[]) set.toArray(); 
		
//		Arrays.sort(arr, Collections.reverseOrder()); 
//		
//		for(String s : arr) {
//			sb.append(s).append("\n"); 
//		}
//		
//		System.out.println(sb);
		
		set.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println); 
	}

}