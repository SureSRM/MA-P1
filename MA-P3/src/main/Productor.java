import java.util.Random;

/**
 * Created by sergio on 23/03/17.
 */
public class Productor implements  Runnable{

    private static Pila pila;
    private static Random rand;


    public Productor(Pila p){
        this.pila=p;
        rand = new Random();
    }

    public void run(){
        int num=0;
        for (int i = 0; i < 15; i++) {
            num=Math.abs(rand.nextInt());
            ConcurrentLog.log("Produce " +num);
            pila.push(num);
            try{
                Thread.sleep(rand.nextInt(2000));
            } catch (InterruptedException e ){

            }
        }
        pila.push(-1);
        ConcurrentLog.log("Productor finished");
    }
}
