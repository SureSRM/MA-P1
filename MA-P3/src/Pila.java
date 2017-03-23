/**
 * Created by sergio on 23/03/17.
 */
public class Pila {

    private static final int BLOCK_SIZE=10;

    private int[] pila;
    private int pointer;

    public Pila(){
        pila=new int[0];
        pointer=0;
    }

    public synchronized int size(){
        return pointer-1;
    }

    public synchronized int bytesInMemory(){
        return pila.length*Integer.BYTES;
    }

    public synchronized void push(int e){
        if(pointer==pila.length){
            incrementSize();
        }
        pila[pointer]=e;
        pointer++;

    }

    public synchronized int pop(){
        if(pointer<=0){
            throw new IndexOutOfBoundsException();
        }
        pointer--;
        int aux = pila[pointer];
        pila[pointer]=0;//Optional

        if(pila.length-pointer==BLOCK_SIZE){
            decrementSize();
        }
        return aux;
    }

    private void incrementSize(){
        int[] aux = new int[pila.length+BLOCK_SIZE];
        for (int i = 0; i < pila.length; i++) {
            aux[i]=pila[i];
        }
        pila=aux;
    }
    private void decrementSize(){
        int[] aux = new int[pila.length-BLOCK_SIZE];
        for (int i = 0; i < aux.length; i++) {
            aux[i]=pila[i];
        }
        pila=aux;
    }

}
