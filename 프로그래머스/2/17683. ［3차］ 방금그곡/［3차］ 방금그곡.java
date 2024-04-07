import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        int maxPlayingTime = 0;
        String answer = "";
        
        // 네오가 기억한 멜로디를 치환한다.
        
        m = changeCode(m);
        
        for (String musicInfo : musicinfos) { 
        	String[] info = musicInfo.split(",");

        	// 재생된 시간 구하기
            
        	int playingTime = (Integer.parseInt(info[1].substring(0, 2)) 
            				- Integer.parseInt(info[0].substring(0, 2)))*60  
        				+ Integer.parseInt(info[1].substring(3)) 
                    			- Integer.parseInt(info[0].substring(3));
        	
        	// 악보 정보(=info[3]) #이 붙은 음 치환하기
        	
        	info[3] = changeCode(info[3]);
        	
        	// 음악 길이 구하기
        	
        	int musicLength = info[3].length();
        	
        	// 실제 재생된 음악 악보 구하기
        	
        	String musicCode = "";
        	
        	// 재생 시간 > 음악 길이 : 처음부터 음악 반복 재생
        	
        	if (playingTime > musicLength) {
        		for (int j=0; j<playingTime/musicLength; j++) {musicCode += info[3];}
        		musicCode += info[3].substring(0, playingTime%musicLength);
        	}
        	
        	// 재생 시간 <= 음악 길이 : 처음부터 재생된 시간만큼 재생
        	
        	else {musicCode += info[3].substring(0, playingTime);}
        	
            	// answer = 네오가 기억하는 멜로디를 포함하면서 
            	// 제일 재생 시간이 긴 음악 제목(=info[2])
            
        	if (musicCode.contains(m) && playingTime > maxPlayingTime) {
        		answer = info[2];
        		maxPlayingTime = playingTime;
        	}
        	
        }	
        
        // 조건이 일치하는 음악이 없는 경우 answer = (None)
        
        if (maxPlayingTime == 0) { answer = "(None)"; }
        
        return answer;
    }
    
    // #이 붙은 음을 치환하는 함수
    
    public static String changeCode(String code) {
        code = code.replaceAll("C#", "c");
        code = code.replaceAll("D#", "d");
        code = code.replaceAll("F#", "f");
        code = code.replaceAll("G#", "g");
        code = code.replaceAll("A#", "a");
        code = code.replaceAll("B#", "b");
        
        return code;
    }
}