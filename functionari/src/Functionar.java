import java.util.Random;

public class Functionar extends Thread {
    private MemoriaImprimanta memoriaImprimanta;
    private long delay;
    private String name;


    public Functionar(String name,MemoriaImprimanta memoriaImprimanta, long delay) {
        this.name = name;
        this.memoriaImprimanta = memoriaImprimanta;
        this.delay = delay;
    }


    @Override
    public void run() {

        while(true) {
            System.out.println("Functionarul " + this.name + " incearca sa foloseasca imprimanta!");
            memoriaImprimanta.print(this.name);
            try {
                // TODO de sters delay ca si argument de aici
//                long currentDelay = 1000 + new Random().nextInt(1000);
                sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
