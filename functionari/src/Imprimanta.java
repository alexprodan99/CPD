public class Imprimanta extends Thread{
    // imprimanta este consumer!!!
    private MemoriaImprimanta memoriaImprimanta;
    private long delay;
    public Imprimanta(MemoriaImprimanta memoriaImprimanta, long delay)
    {
        this.memoriaImprimanta = memoriaImprimanta;
        this.delay = delay;
    }


    @Override
    public void run() {
        System.out.println("Initializare imprimanta!");
        while(true) {
            memoriaImprimanta.lasaImprimanta();
            try {
                sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
