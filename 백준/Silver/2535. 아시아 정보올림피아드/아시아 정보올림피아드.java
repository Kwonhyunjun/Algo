import java.io.*;
import java.util.*;

public class Main {
	
	static class Data implements Comparable<Data>{
		int country, num, score; 
		
		public Data(int country, int num, int score){
			this.country = country;
			this.num = num;
			this.score = score;
		}
		
		@Override
		public int compareTo(Data o) {
			
			return -(this.score - o.score);
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Data[] arr = new Data[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int country = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			
			arr[i] = new Data(country, num, score);
		}
		
		Arrays.sort(arr);
		
		HashMap<Integer, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		int cnt = 0; 
		
		for(int i=0; i<N; i++) {
			if(cnt == 3) break;
			Data cur = arr[i];
			
			if(map.containsKey(cur.country)) {
				if(map.get(cur.country) == 2) {
					continue;
				}
				
				sb.append(cur.country).append(" ").append(cur.num).append("\n");
				map.put(cur.country, map.get(cur.country)+1); 
			}else {
				sb.append(cur.country).append(" ").append(cur.num).append("\n");
				map.put(cur.country, 1); 
			}
			cnt++; 
		}

		System.out.println(sb);
	}

}