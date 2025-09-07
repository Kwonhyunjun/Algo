import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
    
        int gcd = getGCD(num1, num2); 
       
        System.out.println(gcd);
        System.out.println(((num1*num2)/gcd));
        
    }

    private static int getGCD(int num1, int num2) {
       
        if (num1%num2 == 0) return num2;

        return getGCD(num2, num1%num2);
    }
    
}