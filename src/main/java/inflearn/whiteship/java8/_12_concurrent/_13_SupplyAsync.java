package inflearn.whiteship.java8._12_concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

@Slf4j
public class _13_SupplyAsync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // supplyAsync() 메소드는 리턴 값이 있음.
        CompletableFuture<String> future = CompletableFuture.supplyAsync(getSupplier("Java8"));

        // 리턴 값이 있으므로 future.get() 의 결과는 "Java8" 임.
        log.info("future.get(): {}", future.get());
    }

    private static Supplier<String> getSupplier(String message) {
        return () -> {
            log.info("Hello, {}({})", message, Thread.currentThread().getName());
            return message;
        };
    }
}
