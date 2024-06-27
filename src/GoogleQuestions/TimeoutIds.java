import java.util.HashMap;
import java.util.Map;

class Log{
    String id;
    int timeout;
    String msg;
    public Log(String id, int timeout, String msg) {
        this.id = id;
        this.timeout = timeout;
        this.msg = msg;
    }
}
public class TimeoutIds{
    static boolean isTimeoutLogs(Log[] logs, int timeout){
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(int index = 0; index < logs.length; index++){
            Log log = logs[index];

            if(map.containsKey(log.id)){
                continue;
            }

            map.put(log.id, log.timeout);
            // Traverse and checkout any other previous log id got timeout
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                int time = entry.getValue();
                if(log.timeout > time + timeout){
                    System.out.println("Timeout Id : " +  entry.getKey() +" - "+ time);
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Log[] logs = new Log[5];

        logs[0] = new Log("0", 1 , "start");
        logs[1] = new Log("1", 1 , "start");
        logs[2] = new Log("0", 2 , "end");
        logs[3] = new Log("2", 3 , "start");
        logs[4] = new Log("1", 7 , "end");

        boolean isTimeout = isTimeoutLogs(logs, 3);
        System.out.println("Ans " + isTimeout);

    }
}