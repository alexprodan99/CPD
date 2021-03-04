import java.io.*;
import java.util.Random;

public class Operations {

    private int nrOfReaders = 0;
    private String fileName;

    public Operations(String fileName) {
        this.fileName = fileName;
    }

    public String read(int nrOfReader) throws IOException {

        synchronized (this) {
            this.nrOfReaders++;
            System.out.println("Reader " + nrOfReader + " is starting reading");
        }


        int c;
        FileReader fileReader = null;
        BufferedReader bf = null;
        try {
            fileReader = new FileReader(fileName);

            bf = new BufferedReader(fileReader);


            StringBuilder sb = new StringBuilder();

            sb.append(bf.readLine());
//            while((c = fileReader.read()) != -1) {
//                sb.append(c);
//            }


            System.out.println("Reader " + nrOfReader + " read: " + sb.toString());

//            Thread.sleep(500 + new Random().nextInt(1000));

            synchronized (this) {
                System.out.println("Reader " + nrOfReader + " is stopping reading!");
                this.nrOfReaders--;

                if (nrOfReader == 0) {
                    notifyAll();
                }
            }

            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(fileReader != null) {
                fileReader.close();
            }
        }

        return null;



    }


    public synchronized void write(int nrOfWriter) throws IOException {
        while(this.nrOfReaders != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Writer " + nrOfWriter + " is starting writing.");

        FileWriter fileWriter = null;
        Random randomGenerator = new Random();

        String content = String.valueOf(randomGenerator.nextInt(1000));
        try {
            fileWriter = new FileWriter(fileName);

            fileWriter.write(content);

            System.out.println("Writer " + nrOfWriter + " wrote: " + content);


//            Thread.sleep(1000 + new Random().nextInt(1000));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileWriter != null) {
                fileWriter.flush();
                fileWriter.close();
            }
        }

        System.out.println("Writer " + nrOfWriter + " is stopping writing");
        notifyAll();
    }
}
