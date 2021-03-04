import java.io.IOException;

public class Writer extends Thread {
    private int writerNr;
    private Operations operations;

    public Writer(int writerNr, Operations operations) {
        this.writerNr = writerNr;
        this.operations = operations;
    }






    @Override
    public void run() {
        while(true) {
            try {
                operations.write(writerNr);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
