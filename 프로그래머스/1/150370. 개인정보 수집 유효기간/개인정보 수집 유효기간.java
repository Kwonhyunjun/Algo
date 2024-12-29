import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Solution {
    
    static HashMap<Character, Integer> map; 
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>();
        map = new HashMap<>(); 
        
        for (String term : terms) {
            String[] parts = term.split(" ");
            char type = parts[0].charAt(0);
            int duration = Integer.parseInt(parts[1]);
            map.put(type, duration);
        }
        
        LocalDate currentDate = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        
        int cnt = 1;
        for (String privacy : privacies) {
            String[] parts = privacy.split(" ");
            LocalDate expirationDate = calculateExpirationDate(parts[0], parts[1].charAt(0));
            
            if (expirationDate.isBefore(currentDate)) {
                list.add(cnt);
            }
            cnt++;
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
    
    static LocalDate calculateExpirationDate(String date, char type) {
        LocalDate startDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        int duration = map.get(type);
        
        LocalDate expirationDate = startDate.plusMonths(duration).minusDays(1);
        
        return expirationDate;
    }
}
