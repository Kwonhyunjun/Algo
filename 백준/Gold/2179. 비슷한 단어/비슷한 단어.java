import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static String[] arr; 
	static List<Data> words;
	
	static class Data implements Comparable<Data> {
		String word; 
		int idx;
		
		public Data(String word, int idx) {
			this.word = word;
			this.idx = idx; 
		}
		
		@Override
		public int compareTo(Data o) {
			int wordCompare = this.word.compareTo(o.word);
	        if (wordCompare == 0) {
	            return Integer.compare(this.idx, o.idx); // 단어가 같다면 idx 기준 정렬
	        }
	        return wordCompare;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		words = new ArrayList<>();
		arr = new String[N];
		
		for (int i = 0; i < N; i++) { 
			String str = br.readLine();
			arr[i] = str;
			words.add(new Data(str, i));
		}
		
		// 사전순 정렬
		Collections.sort(words);

		// 접두사 길이 저장 배열
		int[] lengthes = new int[N]; 
		int maxLen = 0; 
		
		// 최장 접두사 길이 계산
		for (int i = 0; i < N - 1; i++) {
			Data first = words.get(i);
			Data second = words.get(i + 1);
			
			int tmp = check(first.word, second.word);
			maxLen = Math.max(tmp, maxLen);
			
			lengthes[first.idx] = Math.max(lengthes[first.idx], tmp);
			lengthes[second.idx] = Math.max(lengthes[second.idx], tmp);
		}

//		System.out.println(maxLen);
//		System.out.println(Arrays.toString(lengthes));
		
		String first = null;
		String pre = null;
		for(int i=0; i<N; i++) {
			if(first == null && lengthes[i] == maxLen) {
				first = arr[i];
				pre = first.substring(0, maxLen);
//				System.out.println("pre " + pre);
				System.out.println(first);
			}else if(lengthes[i] == maxLen && pre.equals(arr[i].substring(0, maxLen))) {
				System.out.println(arr[i]);
				break;
			}
		}
		
		
	}
	
	// 접두사 길이 계산 함수
	static int check(String word1, String word2) {
		int min = Math.min(word1.length(), word2.length());
		int res = 0; 
		for (int i = 0; i < min; i++) {
			if (word1.charAt(i) == word2.charAt(i)) {
				res++;
			} else {
				break;
			}
		}
		return res; 
	}
}