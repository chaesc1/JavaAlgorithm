import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();
        char[] c = s.toCharArray();

        Stack<Character> stack = new Stack<>(); //폭탄이 아니면 push
        StringBuilder sb = new StringBuilder();
        for(char ch : c){
            stack.push(ch); // 스택에 모든 문자 push
            int count = 0;
            if(stack.size() >= bomb.length()) {
                for (int i = 0; i < bomb.length(); i++) {
                    if(stack.get(stack.size()-bomb.length()+i) == bomb.charAt(i)){
                        count++;
                    }

                    if(count == bomb.length()) {
                        for (int j = 0; j < count; j++) {
                            stack.pop();
                        }
                    }
                }
            }
        }
        if(stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            for(char ch : stack) {
                sb.append(ch);
            }
        }
        System.out.println(sb);
    }
}
