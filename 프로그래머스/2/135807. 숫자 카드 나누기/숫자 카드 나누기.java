import java.util.*; 

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA = commonGCD(arrayA);
        int gcdB = commonGCD(arrayB);
        
        List<Integer> commonDA = findCommonDivisor(gcdA); 
        List<Integer> commonDB = findCommonDivisor(gcdB); 
        
       
        Collections.sort(commonDA, Collections.reverseOrder());
        Collections.sort(commonDB, Collections.reverseOrder());
        
        // System.out.println(commonDA);
        // System.out.println(commonDB);
        
        for(int a : commonDA){
            boolean flag = true; 
            for(int n : arrayB){
                if(n % a == 0){
                    flag = false; 
                    break; 
                }
            }
            
            if(flag){
                answer = Math.max(answer, a);
            }
        }
        
        for(int b : commonDB){
            boolean flag = true; 
            for(int n : arrayA){
                if(n % b == 0){
                    flag = false; 
                    break; 
                }
            }
            
            if(flag){
                answer = Math.max(answer, b);
            }
        }
        
        // for(int b : commonDB){
        //     if(!commonDA.contains(b)){
        //         answer = Math.max(answer, b);
        //     }
        // }
        
        if(answer == 1) answer = 0; 
        
        return answer;
    }
    
    static List<Integer> findCommonDivisor(int n){
        List<Integer> list = new ArrayList<>(); 
        
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n % i == 0){
                list.add(i);
                if(i * i != n) list.add(n/i); 
            }
        }
        list.add(n); 
        return list; 
    }
    
    static int commonGCD(int[] arr){
        int common = arr[0]; 
        
        for(int i=1; i<arr.length; i++){
            common = gcd(common, arr[i]);
        }
        
        return common; 
    }
    
    static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b); 
    }
}