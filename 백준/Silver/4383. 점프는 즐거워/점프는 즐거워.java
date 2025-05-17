import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) { //EOF면 종료
			//입력할 숫자 개수 입력
			int n = sc.nextInt();
			int[] arr = new int[n];
			int[] array = new int[n];
			int[] num = new int[n - 1];
			int index = 0;
			int check = 0;
			
			//숫자 입력
			for(int i = 0; i < n; i++) {
				arr[i] = 0;//초기화
				arr[i] = sc.nextInt();
			}
			
			//이웃하는 숫자끼리 뺀 값 저장
			for(int i = n - 1; i >= 1; i--) {
				array[index] = 0;//초기화
				array[index] = Math.abs(arr[i] - arr[i - 1]); //이웃한 값끼리 뺀 값
				index++;
			}
			
			//1부터 n - 1만큼 check에 저장
			for(int i = 0; i < n - 1; i++) {
				num[i] = 0; //초기화
				num[i] = i + 1;
			}
			
			for(int i = 0; i < index; i++) {
				
				check = 0; //초기화
				for(int j = 0; j < n - 1; j++) {
					
					if(array[i] == num[j]) { //check중 뺀 값이 있다면
						check = 1;
						num[j] = 0;
					}
				}
				
				if(check == 0) //없으면 종료
					break;
			}
	
			if(n == 1 || check == 1) //길이가 1이면 무조건 jolly
				System.out.println("Jolly");
			
			else
				System.out.println("Not jolly");
		
		}
		
	}	

}