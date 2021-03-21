import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        int i;
        for (i = 1; i <= 1000; i++) {
            System.out.println("сообщение №" + i +
                    " от потока " + Thread.currentThread().getName());
            Thread.sleep(5);
        }
        return "поток " + Thread.currentThread().getName() +
                " отправил " + (i - 1) + " сообщений";
    }
}
