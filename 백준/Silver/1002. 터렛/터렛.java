import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			
			double x1 = Integer.parseInt(st.nextToken());
			double y1 = Integer.parseInt(st.nextToken());
			double r1 = Integer.parseInt(st.nextToken());
			
			double x2 = Integer.parseInt(st.nextToken());
			double y2 = Integer.parseInt(st.nextToken());
			double r2 = Integer.parseInt(st.nextToken());
			
			
			
			if(x1 == x2 && y1 == y2) {
				sb.append((r1 == r2) ? -1 : 0); 
			}else {
				double d = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
				
				if(d == (r1 + r2)){
					sb.append(1);
				}else if(d > (r1 + r2)) {
					sb.append(0);
				}else if(d < (r1 + r2)) {
					double min = Math.min(r1, r2);
					double max = Math.max(r1, r2);
					
					if(max > d+min) {
						sb.append(0);
					}else if(max - min == d) {
						sb.append(1);
					}else {
						sb.append(2);
					}
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}