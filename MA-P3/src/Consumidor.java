import java.util.Random;

/**
 * Created by sergio on 23/03/17.
 */
public class Consumidor implements Runnable{
    private static Pila pila;
    private static int suma=0, n=0;

    public Consumidor(Pila p){
        this.pila=p;
    }

    public void run(){
        int numero=0;
        while(numero!=-1){
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
            while(pila.size()>0) {
                numero = pila.pop();
                if(numero!=-1) {
                    ConcurrentLog.log("Consume " + numero);
                    suma += numero;
                    n++;
                }
            }
        }

        ConcurrentLog.log("Consumidor termina. La media es " + suma/n);
    }

}
