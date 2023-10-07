package Programmers.level3;
//불량사용자

import java.util.HashSet;
import java.util.Set;

class Solution64064 {
    // Set to store the sets of banned user IDs
    private Set<Set<String>> result = new HashSet<>();
    private boolean[] visited;

    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        dfs(new HashSet<>(), user_id, banned_id, 0);
        return result.size();
    }

    private void dfs(Set<String> currentSet, String[] user_id, String[] banned_id, int depth) {
        if (depth == banned_id.length) {
            // If we have reached the end of the banned_id list, add the current set to the result
            result.add(new HashSet<>(currentSet));
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i] && isMatch(user_id[i], banned_id[depth])) {
                visited[i] = true;
                currentSet.add(user_id[i]);
                dfs(currentSet, user_id, banned_id, depth + 1);
                currentSet.remove(user_id[i]);
                visited[i] = false;
            }
        }
    }

    private boolean isMatch(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }

        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) != '*' && bannedId.charAt(i) != userId.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

public class P64064 {
    public static void main(String[] args) {
        Solution64064 solution = new Solution64064();
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};
        int answer = solution.solution(user_id, banned_id);
        System.out.println(answer);
    }
}
