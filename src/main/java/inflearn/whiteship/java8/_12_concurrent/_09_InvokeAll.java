package inflearn.whiteship.java8._12_concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class _09_InvokeAll {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Callable<String> java8 = getCallable("Java8", 3000L);
        Callable<String> spring = getCallable("Spring", 2000L);
        Callable<String> ninjasul = getCallable("ninjasul", 1000L);

        long start = System.currentTimeMillis();

        // invokeAll() 메소드는 모든 작업이 끝날 때 까지 대기함.
        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(java8, spring, ninjasul));
        log.info("Got futures - elapsed: {}", (System.currentTimeMillis()-start));

        for (Future<String> future : futures) {
            log.info("{}", future.get());
        }

        executorService.shutdown();
    }

    private static Callable<String> getCallable(String name, long millis) {
        return () -> {
            long start = System.currentTimeMillis();
            Thread.sleep(millis);
            return "Hello, " + name + "- elapsed: " + (System.currentTimeMillis()-start);
        };

    }
}
