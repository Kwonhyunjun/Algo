import java.io.*;
import java.util.*;

public class Main {
	
	static class Data implements Comparable<Data>{
		String name;
		int korean, english, math;
		
		public Data(String name, int korean, int english, int math) {
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}
		
		@Override
		public int compareTo(Data o1) {
			
			if(this.korean == o1.korean) {
				
				if(this.english == o1.english) {
					
					if(this.math == o1.math) {
						return this.name.compareTo(o1.name);
					}
					
					return -(this.math - o1.math);
				}
				
				return this.english - o1.english;
			}
			
			return -(this.korean - o1.korean); 
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());

		Data[] arr = new Data[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			String name = st.nextToken();
			int korean = Integer.parseInt(st.nextToken());
			int english = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			
			arr[i] = new Data(name, korean, english, math);
		}
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(arr[i].name).append("\n");
		}
		
		System.out.println(sb);
	}

}