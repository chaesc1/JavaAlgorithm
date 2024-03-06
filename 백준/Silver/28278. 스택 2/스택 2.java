import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("1")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (command.equals("2")) {
                if (!stack.isEmpty()) {
                    sb.append(stack.pop()).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
            } else if (command.equals("3")) {
                sb.append(stack.size()).append("\n");
            } else if (command.equals("4")) {
                if (!stack.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append("1").append("\n");
                }
            } else if (command.equals("5")) {
                if (!stack.isEmpty()) {
                    int num = stack.pop();
                    sb.append(num).append("\n");
                    stack.push(num);
                } else {
                    sb.append("-1").append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
