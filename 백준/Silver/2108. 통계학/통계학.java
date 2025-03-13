import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double sum = 0;
		int max = -4001;
		int min = 4001;
		
		List<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			sum += num;
			min = Math.min(min, num);
			max = Math.max(max, num);
			list.add(num);
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		
		// 산술평균
		double avg = sum / N; 
		if(avg < 0 && avg > -1) {
			avg = 0.0;
		}
		System.out.printf("%.0f\n", avg);
		
		// 중앙값 
		Collections.sort(list);
		System.out.println(list.get(N/2));
		
		
		// 최빈값
		int frequent = 0;
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int value = entry.getValue();
			if(value > frequent) {
				frequent = value;
			}
		}
		
		List<Integer> frequentNum = new ArrayList<>();
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int value = entry.getValue();
			if(value != frequent) continue; 
			frequentNum.add(entry.getKey());
		}
		
//		System.out.println(frequentNum);
		int idx = 0; 
		if(frequentNum.size() > 1) {
			Collections.sort(frequentNum);
			idx = 1; 
		}
		
		System.out.println(frequentNum.get(idx));
		
		System.out.println(max - min); 
		

	}

}