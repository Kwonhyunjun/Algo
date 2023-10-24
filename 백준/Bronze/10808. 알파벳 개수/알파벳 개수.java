import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] alphabet; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		String str = sc.next(); 
		char[] chars = str.toCharArray(); 
		
		alphabet = new int[26]; 
		
		for(char c : chars) {
			int idx = c-97; 
			alphabet[idx]++; 
		}
		
		for(int a : alphabet) {
			System.out.print(a +" ");
		}
	}
}