package inflearn.whiteship.java8._12_concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class _10_InvokeAny {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> java8 = getCallable("Java8", 3000L);
        Callable<String> spring = getCallable("Spring", 2000L);
        Callable<String> ninjasul = getCallable("ninjasul", 1000L);

        long start = System.currentTimeMillis();

        // invokeAny() 메소드는 가장 빨리 끝난 작업의 결과 하나를 리턴 함.
        String result = executorService.invokeAny(Arrays.asList(java8, spring, ninjasul));
        log.info("Got futures - elapsed: {}", (System.currentTimeMillis()-start));
        log.info("{}", result);

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
