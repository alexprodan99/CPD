import java.util.Random;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Functionar[] functionari = new Functionar[8];

        MemoriaImprimanta memoriaImprimanta = new MemoriaImprimanta();

        for(int i = 0; i < 8; i++) {
            long currentDelay = 1000 + new Random().nextInt(1000);
            functionari[i] = new Functionar("Name" + i,memoriaImprimanta, currentDelay);
        }

        Imprimanta imprimanta = new Imprimanta(memoriaImprimanta, 100);

        imprimanta.start();

        for(int i = 0; i < 8; i++) {
            functionari[i].start();
//            functionari[i].join();
        }

    }
}
