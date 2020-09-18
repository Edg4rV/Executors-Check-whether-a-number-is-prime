import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executor; // assign an object to it
        executor = Executors.newCachedThreadPool();
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            // create and submit tasks
            executor.submit(new PrintIfPrimeTask(number));
        }
        executor.shutdown();
    }
}

class PrintIfPrimeTask implements Runnable {
    private final int number;

    public PrintIfPrimeTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        if (number == 2) {
            System.out.println(number);
            return;
        }
        if (number < 2 || number % 2 == 0) {
            return;
        }
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return;
            }
        }
        System.out.println(number);
    }
}
