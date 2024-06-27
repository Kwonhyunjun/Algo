class Solution {
    
    /*
        skill : 선행 스킬 순서 
        skill_trees : 스킬트리를 담은 배열
        
        return 가능한 스킬트리 개수
    */
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        // char[] order = skill.toCharArray(); 
        // boolean[] v = new boolean[skill.length()]; 
        
        String regex = "[^" + skill + "]"; 
        System.out.printf("%s \n", regex); 
        
        for(String tree : skill_trees){
            String extract = tree.replaceAll(regex, ""); 
            // System.out.printf("extract : %s \n", extract);
            
            String s = skill.substring(0, extract.length()); 
            // System.out.printf("s : %s\n", s); 
            
            if(extract.equals(s)){
                answer++;
            }
            
            
        }
        
        return answer;
    }
}