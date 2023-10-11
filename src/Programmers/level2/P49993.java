package Programmers.level2;

class Solution49993 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        //skill_tree 를 순회 해야해
        for(String skilltree : skill_trees){
            String tempStr = skilltree;
            for (int i = 0; i < skilltree.length(); i++) {
                String s = skilltree.substring(i,i+1);
                if(!skill.contains(s)){
                   tempStr = tempStr.replace(s,"");
                }

            }
            if(skill.indexOf(tempStr) == 0){
                answer++;
            }
        }
        return answer;
    }
}
public class P49993 {
    public static void main(String[] args) {
        Solution49993 sol = new Solution49993();
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println("sol.solution(skill,skill_trees) = " + sol.solution(skill,skill_trees));
    }
}
