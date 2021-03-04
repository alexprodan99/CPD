public class MemoriaImprimanta {
    private boolean canPrint = true;
    private String currentData;

    public synchronized void print(String document) {
        while(!canPrint) {
            try {
                System.out.println("Inca nu poti folosi imprimanta!Cineva o foloseste deja! Trebuie sa astepti");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Se printeaza la imprimanta!" + document);
        currentData = document;
        canPrint = false;
        notifyAll();
    }

    public synchronized String lasaImprimanta() {
        while(canPrint) {
            System.out.println("Inca nu se poate lasa imprimanta libera!Cineva inca printeaza la ea!");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Se lasa imprimanta libera!");
        canPrint = true;
        notifyAll();
        return currentData;
    }
}
