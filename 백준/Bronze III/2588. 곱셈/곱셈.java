import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); 
		int M = Integer.parseInt(br.readLine()); 
		
		int sum = 0; 
		
		System.out.println(N * (M % 10));
		System.out.println(N * ((M / 10) % 10));
		System.out.println(N * (M / 100));
		System.out.println(N * M);
	}

}