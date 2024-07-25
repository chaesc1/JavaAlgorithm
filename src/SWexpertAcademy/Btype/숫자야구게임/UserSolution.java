package SWexpertAcademy.Btype.숫자야구게임;

class UserSolution {
    public final static int N = 4;
    static boolean[] isPossible;
    static int[] num;
    static int index;

    void init() {
        index = 0;
        num = new int[5040];
        isPossible = new boolean[9877];

        for (int i = 123; i <= 9876; i++) {
            int n1 = i / 1000;
            int n2 = i % 1000 / 100;
            int n3 = i % 100 / 10;
            int n4 = i % 10;

            if (n1 != n2 && n1 != n3 && n1 != n4 && n2 != n3 && n2 != n4 && n3 != n4) {
                num[index++] = i;
                isPossible[i] = true;
            }
        }
    }

    public void doUserImplementation(int guess[]) {
        // Implement a user's implementation function
        //
        // The array of guess[] is a return array that
        // is your guess for what digits[] would be.
        init();
        int answer = 0;
        int strike = 0;
        int ball = 0;
        int target = 0;
        int result = 0;
        int[] ballCount;

        while (true) {
            for (int i = 0; i < index; i++) {
                if (isPossible[num[i]]) {
                    answer = num[i];
                    guess[0] = answer / 1000;
                    guess[1] = answer % 1000 / 100;
                    guess[2] = (answer % 100) / 10;
                    guess[3] = answer % 10;
                    break;
                }
            }

            Solution.Result results = Solution.query(guess);
            if (results.strike == 4) break;
            else isPossible[answer] = false;

            for (int i = 0; i < index; i++) {
                if (isPossible[num[i]]) {
                    result = answer;
                    target = num[i];
                    ball = 0;
                    strike = 0;
                    ballCount = new int[10];

                    for (int j = 0; j < 4; j++) {
                        if (result % 10 == target % 10) strike++;
                        else {
                            ballCount[result % 10]++;
                            ballCount[target % 10]++;
                        }
                        result /= 10;
                        target /= 10;
                    }
                    for (int j = 0; j < 10; j++) {
                        if (ballCount[j] == 2) ball++;
                    }

                    if (strike != results.strike || ball != results.ball) {
                        isPossible[num[i]] = false;
                    }
                }
            }
        }
    }
}
