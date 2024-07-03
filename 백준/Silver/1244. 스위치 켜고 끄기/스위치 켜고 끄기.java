import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int[] switches = new int[total];

        // 스위치 정보를 받아
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < total; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        //학생 수
        int studentNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            // 남자일때
            if (gender == 1) {
                for (int j = 0; j < total; j++) {
                    if ((j + 1) % number == 0) {
                        if (switches[j] == 0) {
                            switches[j] = 1;
                        } else {
                            switches[j] = 0;
                        }
                    }
                }
            } else if (gender == 2){
                // 여자일때
                // 뽑은 수를 기준으로 좌우가 대칭이면 상태를 바꿈
                int left = number - 2;
                int right = number;

                while (left >= 0 && right < total) {
                    if (switches[left] != switches[right]) break;
                    left--;
                    right++;
                }
                // 좌우 대칭아니니까
                left++;
                right--;

                for (int j = left; j <= right; j++) {
                    if (switches[j] == 1) {
                        switches[j] = 0;
                    } else {
                        switches[j] = 1;
                    }

                }
            }
        }

        for (int i = 0; i < total; i++) {
            System.out.print(switches[i] + " ");
            if ((i+1) % 20 == 0) {
                System.out.println();
            }
        }


    }
}
