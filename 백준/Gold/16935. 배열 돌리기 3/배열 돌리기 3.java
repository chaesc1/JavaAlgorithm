import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    // 배열의 크기와 명령어 개수를 저장하는 변수
    static int N, M, R;
    static int[][] arr; // 초기 배열
    static int command; // 처리할 명령어

    static StringBuilder sb = new StringBuilder(); // 결과 출력을 위한 StringBuilder

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        //배열의 크기(N, M)와 수행해야 하는 연산의 수(R) 읽기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        // 배열 초기화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 명령어 읽기
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            command = Integer.parseInt(st.nextToken());
            // 명령어 처리
            solve(command);
        }

        // 결과 출력
        printArr();
        System.out.println(sb.toString());
    }

    // 1번 연산: 배열을 상하 반전시키는 연산
    // 2번 연산: 배열을 좌우 반전시키는 연산
    // 3번 연산: 오른쪽으로 90도 회전시키는 연산
    // 4번 연산: 왼쪽으로 90도 회전시키는 연산
    // 5번 연산: 부분 배열을 시계방향으로 돌리는 연산
    // 6번 연산: 부분 배열을 반시계방향으로 돌리는 연산
    private static void solve(int command) {
        switch (command) {
            case 1:
                // 상하 반전시키는 연산
                int mid = N / 2;
                for (int i = 0; i < mid; i++) {
                    for (int j = 0; j < M; j++) { // 이 부분의 범위를 수정하였습니다.
                        int temp = arr[i][j];
                        arr[i][j] = arr[N - i - 1][j];
                        arr[N - i - 1][j] = temp;
                    }
                }
                break;
            case 2:
                // 좌우 반전시키는 연산
                mid = M / 2;
                for (int j = 0; j < mid; j++) {
                    for (int i = 0; i < N; i++) {
                        int temp = arr[i][j];
                        arr[i][j] = arr[i][M - j - 1];
                        arr[i][M - j - 1] = temp;
                    }
                }
                break;
            case 3:
                // 오른쪽으로 90도 회전시키는 연산
                int[][] newArr = new int[M][N]; // 회전 후의 배열 크기
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        newArr[j][N - i - 1] = arr[i][j];
                    }
                }
                arr = newArr; // 새 배열을 원래 배열로 설정
                int temp = N;
                N = M;
                M = temp;
                break;
            case 4:
                // 왼쪽으로 90도 회전시키는 연산
                newArr = new int[M][N]; // 회전 후의 배열 크기
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        newArr[M - j - 1][i] = arr[i][j];
                    }
                }
                arr = newArr; // 새 배열을 원래 배열로 설정
                temp = N;
                N = M;
                M = temp;
                break;
            case 5:
                // 부분 배열을 시계방향으로 돌리는 연산
                newArr = new int[N][M]; // 새로운 배열 생성
                int halfN = N / 2;
                int halfM = M / 2;
                // 1 -> 2
                for (int i = 0; i < halfN; i++) {
                    for (int j = 0; j < halfM; j++) {
                        newArr[i][j + halfM] = arr[i][j];
                    }
                }
                // 2 -> 3
                for (int i = 0; i < halfN; i++) {
                    for (int j = halfM; j < M; j++) {
                        newArr[i + halfN][j] = arr[i][j];
                    }
                }
                // 3 -> 4
                for (int i = halfN; i < N; i++) {
                    for (int j = halfM; j < M; j++) {
                        newArr[i][j - halfM] = arr[i][j];
                    }
                }
                // 4 -> 1
                for (int i = halfN; i < N; i++) {
                    for (int j = 0; j < halfM; j++) {
                        newArr[i - halfN][j] = arr[i][j];
                    }
                }
                arr = newArr;
                break;
            case 6:
                // 부분 배열을 반시계방향으로 돌리는 연산
                newArr = new int[N][M]; // 새로운 배열 생성
                halfN = N / 2;
                halfM = M / 2;
                // 1 -> 4
                for (int i = 0; i < halfN; i++) {
                    for (int j = 0; j < halfM; j++) {
                        newArr[i + halfN][j] = arr[i][j];
                    }
                }
                // 4 -> 3
                for (int i = halfN; i < N; i++) {
                    for (int j = 0; j < halfM; j++) {
                        newArr[i][j + halfM] = arr[i][j];
                    }
                }
                // 3 -> 2
                for (int i = halfN; i < N; i++) {
                    for (int j = halfM; j < M; j++) {
                        newArr[i - halfN][j] = arr[i][j];
                    }
                }
                // 2 -> 1
                for (int i = 0; i < halfN; i++) {
                    for (int j = halfM; j < M; j++) {
                        newArr[i][j - halfM] = arr[i][j];
                    }
                }
                arr = newArr;
                break;
        }
    }

    // 배열을 출력하는 메서드
    private static void printArr() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) { // 수정: M을 사용
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }
}