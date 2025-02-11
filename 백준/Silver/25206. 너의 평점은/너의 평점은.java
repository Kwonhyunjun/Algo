import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] gradeType = new String[] {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
		double[] gradeScore = new double[] {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};
		
		double answer = 0; 
		double sum = 0;
		
		for(int i=0; i<20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String subject = st.nextToken();
			double score = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();
			
//			System.out.println(subject + " " + score + " " + grade); 
			
			if("P".equals(grade)) continue;
			
//			System.out.println(Arrays.asList(gradeType).indexOf(grade));
			
			int idx = Arrays.asList(gradeType).indexOf(grade); 
//			System.out.println(gradeScore[idx]);
//			System.out.println(score);
//			System.out.println(score * gradeScore[idx]);
			answer += score * gradeScore[idx];
			sum += score;
		}
		
//		System.out.println(answer);
//		System.out.println(sum);
		System.out.println(answer/sum);
		
		

	}

}