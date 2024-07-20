package liveCodingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class P2 {
    public static void main(String[] args) throws Exception {
//        - 파일에서 로그를 읽고 형태를 변환해서 다른 파일로 저장한다.
//                - 변환하는 과정에서 다양한 요구사항을 해결한다.
//        - 버전 디폴트를 우선 구현한 후, 버전 A ~E 중에서 원하는 버전을 하나 또는 복수 선택하여 코딩한다.
//        - **[필수] 버전 디폴트**
//        - 구분자 탭(’\t’)을 콤마(,)로 변환해서 저장한다.
//                - 입력 데이터가 콤마(,)를 포함하고 있을 경우 이를 다른 문자(예: Space)로 변환해야 한다. 즉 변환 결과에는 콤마 문자가 구분자로서만 존재해야 한다.

        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/chaejunghun/Downloads/logfile"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("#")) {
                    line = line.replace(',', ' '); // 콤마를 포함하는 경우 스페이스로 반환 - > 콤마문자는 구분자로서만
                    line = line.replace('\t', ',');
                    bw.write(line);
                    bw.newLine();
                }
            }

            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
