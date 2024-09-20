import java.io.*;
import java.util.*; 

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		HashSet<Integer> set = new HashSet<>(); 
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N]; 
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int answer = 0; 
		
		for(int i=0; i<N; i++) {
			int left = 0; 
			int right = N-1; 
			
			while(true) {
				
				// 자기 자신을 더하는 경우는 빼야 함
				if(left == i) left++; 
				if(right == i) right--;
				
				if(left >= right) break;
				
				if(arr[left] + arr[right] > arr[i]) {
					right--;
				}else if(arr[left] + arr[right] < arr[i]) {
					left++;
				}else {
					answer++; 
					break; 
				}
				
			}
		}
		
		System.out.println(answer); 

	}

}