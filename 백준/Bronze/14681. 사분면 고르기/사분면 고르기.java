import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int answer = 0;
		
		if(x > 0) {
			if(y > 0) {
				answer = 1;
			}else {
				answer = 4;
			}
		}else {
			if(y > 0) {
				answer = 2;
			}else {
				answer = 3;
			}
		}

		System.out.println(answer);
	}

}