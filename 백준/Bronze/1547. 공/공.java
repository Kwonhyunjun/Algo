import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] cups = new int[4];
		
		int N = sc.nextInt();
		for(int i=0; i<4; i++) {
			cups[i] = i;
		}
		
		for(int i=0; i<N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			 
			int temp = cups[a];
			cups[a] = cups[b];
			cups[b] = temp; 
		}
		
		int ans = 0; 
		for(int i=1; i<4; i++) {
			if(cups[i] == 1) {
				ans = i; 
			}
		}
		System.out.println(ans);
	}

}