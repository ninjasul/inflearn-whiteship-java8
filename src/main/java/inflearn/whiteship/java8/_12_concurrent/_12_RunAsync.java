package inflearn.whiteship.java8._12_concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class _12_RunAsync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // runAsync() 메소드는 리턴 값이 없음.
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            log.info("Hello, {}", Thread.currentThread().getName());
        });

        // 리턴 값이 없으므로 future.get() 의 결과는 null임.
        log.info("future.get(): {}", future.get());
    }
}
