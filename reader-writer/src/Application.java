public class Application {
    public static void main(String[] args) {
        Reader[] readers = new Reader[3];
        Writer[] writers = new Writer[3];

        Operations operations = new Operations("D:\\CPD\\lab\\multiple-reads-lock-write\\src\\test.txt");


        for(int i = 0; i < 3; i++) {
            readers[i] = new Reader(i+1, operations);
        }

        for(int i = 0; i < 3; i++) {
            writers[i] = new Writer(i+1, operations);
        }


        for(int i = 0; i < 3; i++) {
            readers[i].start();
        }

        for(int i = 0; i < 3; i++) {
            writers[i].start();
        }

    }
}
