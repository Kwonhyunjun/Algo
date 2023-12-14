import java.io.*;
import java.util.*; 

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		
		int N = Integer.parseInt(br.readLine()); 
		
		List<Integer> pos = new ArrayList<>(); 
		List<Integer> neg = new ArrayList<>(); 
		
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num > 0) {
				pos.add(num);
			}else {
				neg.add(num); 
			}
		}
		
		Collections.sort(pos, Collections.reverseOrder());
		Collections.sort(neg); 
		
		int sum = 0; 
		int i = 0; 
		
		while(i < pos.size()) {
			if(i+1 < pos.size() && pos.get(i) != 1 && pos.get(i+1) !=1){
				sum += pos.get(i++) * pos.get(i++);
			}else {
				sum += pos.get(i++);
			}
		}
		
		i = 0; 
		while(i < neg.size()) {
			if(i+1 < neg.size() && neg.get(i) != 1 && neg.get(i+1) !=1){
				sum += neg.get(i++) * neg.get(i++);
			}else {
				sum += neg.get(i++);
			}
		}
		
		System.out.println(sum);
	}
}