package Inflearn.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 감염된 폴더 문제: 두 노드의 최소 공통 조상(LCA)을 구한다
public class P2 {

    // p에서 root까지의 조상 경로(자신 포함)를 구한 뒤, q의 조상을 하나씩 거슬러 올라가며
    // p의 경로에 처음 포함되는 지점을 찾으면 그것이 최소 공통 조상
    public String solution(String[][] folders, String p, String q) {
        Map<String, String> parent = new HashMap<>();
        for (String[] folder : folders) {
            parent.put(folder[1], folder[0]);
        }

        List<String> pAncestors = new ArrayList<>();
        String cur = p;
        while (cur != null) {
            pAncestors.add(cur);
            cur = parent.get(cur);
        }

        cur = q;
        while (cur != null) {
            if (pAncestors.contains(cur)) return cur;
            cur = parent.get(cur);
        }

        return "root";
    }

    public static void main(String[] args) {
        P2 sol = new P2();

        String[][] folders1 = {{"root", "apps"}, {"apps", "chrome"}, {"apps", "vscode"}};
        System.out.println(sol.solution(folders1, "chrome", "vscode")); // 기대 출력: apps

        String[][] folders2 = {{"root", "usr"}, {"usr", "bin"}, {"usr", "local"}, {"bin", "tools"}};
        System.out.println(sol.solution(folders2, "bin", "tools")); // 기대 출력: bin

        String[][] folders3 = {{"root", "media"}, {"media", "images"}, {"media", "videos"}, {"images", "holiday"}, {"videos", "concert"}};
        System.out.println(sol.solution(folders3, "holiday", "concert")); // 기대 출력: media
    }
}
