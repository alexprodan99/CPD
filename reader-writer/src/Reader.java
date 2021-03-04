import java.io.IOException;

public class Reader extends Thread {
    private int readerNr;

    private Operations operations;


    public Reader(int readerNr, Operations operations) {
        this.readerNr = readerNr;
        this.operations = operations;
    }


    @Override
    public void run() {
        while(true) {
            try {
                String content = operations.read(readerNr);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
