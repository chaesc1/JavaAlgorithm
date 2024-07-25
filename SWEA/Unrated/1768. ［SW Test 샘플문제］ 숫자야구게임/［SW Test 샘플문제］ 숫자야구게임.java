class UserSolution {
    public final static int N = 4;
    static boolean[] isPossible;
    static int[] num;
    static int index;

    void init() {
        index = 0;
        num = new int[5040];
        isPossible = new boolean[9877];

        // 가능한 모든 경우의 수를 저장
        for (int i = 123; i <= 9876; i++) {
            int n1 = i / 1000;
            int n2 = (i / 100) % 10;
            int n3 = (i / 10) % 10;
            int n4 = i % 10;

            // 각 자리의 숫자가 중복되지 않는 경우만 저장
            if (n1 != n2 && n1 != n3 && n1 != n4 && n2 != n3 && n2 != n4 && n3 != n4) {
                num[index++] = i;
                isPossible[i] = true;
            }
        }
    }

    public void doUserImplementation(int guess[]) {
        init();
        int answer = 0;
        int strike, ball, target, result;
        int[] ballCount;

        while (true) {
            // 가능한 숫자 중 하나를 선택
            for (int i = 0; i < index; i++) {
                if (isPossible[num[i]]) {
                    answer = num[i];
                    guess[0] = answer / 1000;
                    guess[1] = (answer / 100) % 10;
                    guess[2] = (answer / 10) % 10;
                    guess[3] = answer % 10;
                    break;
                }
            }

            // 결과를 쿼리
            Solution.Result results = Solution.query(guess);
            if (results.strike == 4) break;  // 정답을 맞춘 경우 종료
            else isPossible[answer] = false;

            // 모든 가능한 숫자에 대해 가지치기
            for (int i = 0; i < index; i++) {
                if (isPossible[num[i]]) {
                    result = answer;
                    target = num[i];
                    ball = 0;
                    strike = 0;
                    ballCount = new int[10];

                    for (int j = 0; j < 4; j++) {
                        int resultDigit = result % 10;
                        int targetDigit = target % 10;
                        if (resultDigit == targetDigit) {
                            strike++;
                        } else {
                            ballCount[resultDigit]++;
                            ballCount[targetDigit]++;
                        }
                        result /= 10;
                        target /= 10;
                    }

                    // 볼 개수 계산
                    for (int j = 0; j < 10; j++) {
                        if (ballCount[j] == 2) ball++;
                    }

                    // 가지치기 조건
                    if (strike != results.strike || ball != results.ball) {
                        isPossible[num[i]] = false;
                    }
                }
            }
        }
    }
}