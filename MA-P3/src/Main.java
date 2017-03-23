public class Main {

    public static void main(String[] args) {
        Pila p = new Pila();
        Thread[] hilos = new Thread[2];

        hilos[0]=new Thread(new Productor(p));
        hilos[1]=new Thread(new Consumidor(p));

        hilos[0].start();
        hilos[1].start();
        try {
            hilos[0].join();
            hilos[1].join();
        } catch (InterruptedException e){

        }
        System.out.println("End");
    }
}
