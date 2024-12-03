import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 
		
		int[][] map = new int[9][9]; 
		
		int max = -1;
		int r = 0;
		int c = 0;
		
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<9; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num > max) {
					max = num; 
					r = i; 
					c = j; 
				}
			}
		}
		
		System.out.println(max);
		System.out.println((r+1) + " " + (c+1));
		

	}

}