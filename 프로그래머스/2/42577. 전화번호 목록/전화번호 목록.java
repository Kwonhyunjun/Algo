import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
//         Arrays.sort(phone_book, new Comparator<String>() {

// 			@Override
// 			public int compare(String o1, String o2) {
// 				// TODO Auto-generated method stub
// 				return o1.length() - o2.length();
// 			}
// 		});
//         // Arrays.sort(phone_book);
//         HashSet<String> set;
//         for(int i=0; i<phone_book.length; i++) {
//         	set = new HashSet<String>();
//         	String curStr = phone_book[i]; // 현재 String 꺼냄
//         	set.add(curStr);
//         	for(int j=i+1; j<phone_book.length; j++) {
//         		String sub = phone_book[j].substring(0, curStr.length());
//         		if(set.contains(sub)) {
//         			return false; 
//         		}
//         	}
//         } 
        
          Arrays.sort(phone_book);
        for(int i=1; i<phone_book.length; i++) {
        	if(phone_book[i].startsWith(phone_book[i-1])) {
        		return false; 
        	}
        }
        
        return answer;
    }
}