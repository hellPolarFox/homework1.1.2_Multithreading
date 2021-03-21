import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    static final List<MyCallable> tasks = new ArrayList<>();
    static final ExecutorService threadPool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors());

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            tasks.add(new MyCallable());
        }

        //SolutionWithInvokeAny();
        SolutionWithInvokeAll();
    }

    public static void SolutionWithInvokeAny() throws ExecutionException, InterruptedException {
        System.out.println(threadPool.invokeAny(tasks));
        threadPool.shutdown();
    }

    public static void SolutionWithInvokeAll() throws ExecutionException, InterruptedException {
        List<Future<String>> results = threadPool.invokeAll(tasks);
        for (Future<String> f : results) {
            String result2 = f.get();
            System.out.println(result2);
        }
        threadPool.shutdown();
    }
}
