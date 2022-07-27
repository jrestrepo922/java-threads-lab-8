import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


//Implement the countFinishedFutures which takes in a List of Future objects
//        and counts how many of the objects completed.
public class Main {
    public static int countFinishedFutures(List<Future> futures) {
        // your code here
        Integer count = 0;
        for(int i = 0; i < futures.size(); i++){
            if(futures.get(i).isDone()){
                ++count;
            }
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> num1 = executor.submit(()-> {
            try {
                Thread.sleep(3000);
                return 1000;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Future<Integer> num2 = executor.submit(()-> {
            try {
                Thread.sleep(500);
                return 2000;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        List<Future> futureList = new ArrayList<Future>(Arrays.asList(num1, num2));

        Main.countFinishedFutures(futureList);
    }
}