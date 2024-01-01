import java.io.*; 
import java.util.*; 

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<>(); 
		
		for(int i=0; i<L; i++) {
			String no = br.readLine();
			
			map.put(no, i); 
		}
		
		// HashMap value(값) 정렬하기
		List<String> keys = new ArrayList<>(map.keySet()); 
		
		Collections.sort(keys, (v1, v2) -> (map.get(v1)).compareTo(map.get(v2)));
		
		int size = Math.min(keys.size(), K); 
		
		for(int i=0; i<size; i++) {
			sb.append(keys.get(i)).append("\n"); 
		}
		
		System.out.println(sb);
	}

}