import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean isOk = true;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int tmp = 1;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            for (; tmp <= num; tmp++) {
                stack.push(tmp);
                sb.append("+").append("\n");
            }

            if (stack.peek() == num) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                isOk = false;
            }
        }

        if(isOk) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }

    }
}
