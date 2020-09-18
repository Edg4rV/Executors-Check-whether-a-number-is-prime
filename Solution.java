import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] convert = input.split(" ");
        int[] arr = new int[convert.length];
        for (int i = 0; i < convert.length; i++) {
            arr[i] = Integer.parseInt(convert[i]);
        }
        Arrays.sort(arr);
//        System.out.println("convert is" + Arrays.toString(arr));

//        System.out.println("input is" + input);
        int lastNum = arr[arr.length - 1];
//        System.out.println("last" + lastNum);
        Scanner sc = new Scanner(input);
        ExecutorService executor = Executors.newCachedThreadPool();

        while (sc.hasNext()) {
            int number = sc.nextInt();
            try {
                executor.submit(() -> {
                    new PrintIfPrimeTask(number).run();
                });
                if (number == lastNum ) {
                    executor.shutdownNow();
                    break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }
}

class PrintIfPrimeTask implements Runnable {
    private final int number;

    public PrintIfPrimeTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        int count = 0;
        for (int i = 1 ; i < 100; i++) {
            if (number % i == 0) {
                count ++;
            }
            }
        if (count == 2) {
            System.out.println(number);
        }
    }
}
