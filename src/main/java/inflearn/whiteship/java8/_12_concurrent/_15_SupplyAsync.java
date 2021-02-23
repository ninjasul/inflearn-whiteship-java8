package inflearn.whiteship.java8._12_concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

@Slf4j
public class _15_SupplyAsync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        /**
         * supplyAsync() 메소드, thenRunAsync() 메소드를 사용하면 별도의 쓰레드 풀을 지정할 수 있음.
         */
        CompletableFuture<Void> future = CompletableFuture
            .supplyAsync(getSupplier("Java8"), executorService)
            .thenRunAsync(getRunnable("Spring5"), executorService);

        // 리턴 값이 없으므로 future.get() 의 결과는 null 임.
        log.info("future.get(): {}", future.get());
        executorService.shutdown();
    }

    private static Supplier<String> getSupplier(String message) {

        return () -> {
            log.info("Hello, {}({})", message, Thread.currentThread().getName());
            return message;
        };
    }

    private static Runnable getRunnable(String message) {
        // thenRunAsync() 메소드의 인자는 Runnable이 들어가므로 인자, 리턴 값 없이 무조건 실행만 해야 함.
        return () -> {
            log.info("thenAccept(): {}({})", message, Thread.currentThread().getName());
        };
    }
}
