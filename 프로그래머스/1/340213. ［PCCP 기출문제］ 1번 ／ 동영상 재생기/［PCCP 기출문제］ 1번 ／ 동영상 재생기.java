class Solution {

    public int timeToSec(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    public String secToTime(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
    
    public int opCheck(int timeToUse, int opStartSec, int opEndSec){
        int nowPosTime = timeToUse;
        if (opStartSec <= timeToUse && timeToUse <= opEndSec){
            nowPosTime = opEndSec;
        }
        return nowPosTime;
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int videoLenSec = timeToSec(video_len);
        int posSec = timeToSec(pos);
        int opStartSec = timeToSec(op_start);
        int opEndSec = timeToSec(op_end);

        int timeToUse = posSec;

        for (String cmd : commands) {
            timeToUse = opCheck(timeToUse, opStartSec, opEndSec);
            if (cmd.equals("next")) {
                timeToUse = Math.min(timeToUse + 10, videoLenSec);  
            } else if (cmd.equals("prev")) {
                timeToUse = Math.max(timeToUse - 10, 0); 
            }
        }

        timeToUse = opCheck(timeToUse, opStartSec, opEndSec);
        return secToTime(timeToUse);
    }
}