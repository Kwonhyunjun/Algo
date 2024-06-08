class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = {};
        
        int index = 0; 
        for(String str : strArr){
            if(index % 2 == 0){
                strArr[index] = str.toLowerCase(); 
            }else{
                strArr[index] = str.toUpperCase(); 
            }
            index++;
        }
        
        return strArr;
    }
}