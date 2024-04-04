import java.util.*;

class Solution {
    //동영상 재생시간 길이 play_time, 공익광고의 재생시간 길이 adv_time, 시청자들이 해당 동영상을 재생했던 구간 정보 logs가 매개변수
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int play = convertTimeToSec(play_time);
        int adv = convertTimeToSec(adv_time);
        int[] times = new int[360_000]; // 100시간 -> 초
        
        for(String log : logs) {
            String[] logInfo = log.split("-");
            int startTime = convertTimeToSec(logInfo[0]);
            int endTime = convertTimeToSec(logInfo[1]);
        
            for(int i=startTime; i < endTime; i++) {
                times[i]++;
            }
        }
        
        int maxTime = 0;
        long totalTime = 0;
        
        for(int i=0; i<adv; i++) {
            totalTime += times[i];
        }
        long max = totalTime;
        for(int i=adv; i<play; i++) {
            totalTime += times[i] - times[i-adv];
            if (totalTime > max) {
                max = totalTime;
                maxTime = i - adv + 1;
            }
        }
        return convertSecToTimeFormat(maxTime);
    }
    
    private static int convertTimeToSec(String time) {
        String[] timeInfo = time.split(":");
        int hours = Integer.parseInt(timeInfo[0]) * 3600;
        int minutes = Integer.parseInt(timeInfo[1]) * 60;
        int seconds = Integer.parseInt(timeInfo[2]);
        return hours + minutes + seconds;
    }
    
    private static String convertSecToTimeFormat(int time) {
        return String.format("%02d:%02d:%02d",
                time/3600,
                (time/60)%60,
                time%60);        
    }
}