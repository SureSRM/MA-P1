/**
 * Created by sergio on 23/03/17.
 */
public class ConcurrentLog {
    public synchronized static void log(String s){
        System.out.println(s);
    }
}
