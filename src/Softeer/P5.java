import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class P5 {
    static Map<String, String> domainToIpMap = new HashMap<>();
    static Map<String, String> ipToDomainMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 입력 처리
        String commandLine = br.readLine();
        StringTokenizer st = new StringTokenizer(commandLine);
        String command = st.nextToken();
        String rangefirst = "";
        String rangeEnd = "";
        switch (command) {
            case "R":
                String domain = st.nextToken();
                String ip = st.nextToken();
//                String[] ip2 = ip.split("-");
//                rangefirst = ip2[0];
//                rangeEnd = ip2[1];
//                if (ip.split(""))
                registerIP(domain, ip);

            case "S":
                // 두 번째 줄 입력 처리
                String secondLine = br.readLine();
                StringTokenizer st2 = new StringTokenizer(secondLine);
                st2.nextToken();//필요없어
                String input = st2.nextToken();
//                System.out.println(input);\
                if (Integer.parseInt(input) >= Integer.parseInt(rangefirst)&& Integer.parseInt(input) <= Integer.parseInt(rangeEnd)){
                    searchDomainOrIP(input);
                }
                searchDomainOrIP(input);
                break;
            case "A":
                String prefix = st.nextToken();
                System.out.println(prefix);
                findDomainWithPrefix(prefix);
                break;
        }
    }

    static void searchDomainOrIP(String input) {
        if (domainToIpMap.containsKey(input)) {
            String ip = domainToIpMap.get(input);
            System.out.println(ip);
        } else if (ipToDomainMap.containsKey(input)) {
            String domain = ipToDomainMap.get(input);
            System.out.println(domain);
        } else {
            System.out.println("Not found");
        }
    }

    static void registerIP(String domain, String ip) {
        domainToIpMap.put(domain, ip);
        ipToDomainMap.put(ip, domain);
    }

    static void findDomainWithPrefix(String prefix) {
        TreeMap<String, String> sortedDomainMap = new TreeMap<>(domainToIpMap);
        // prefix로 시작하는 도메인만 필터링
        sortedDomainMap.entrySet().stream()
                .filter(entry -> entry.getKey().startsWith(prefix))
                .forEach(entry -> System.out.println(entry.getKey()));
    }
}
