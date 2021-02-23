package inflearn.whiteship.java8._12_concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class _11_CompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * CompletableFuture 는 내부적으로 ForkJoinPool 프레임워크를 사용하여 쓰레드 풀을 생성하므로(commonPool을 사용)
         * 별도로 쓰레드 풀을 생성할 필요가 없음.
         * CompletableFuture 객체 생성 후 complete() 메소드를 호출하여 추후 결과 값을 지정할 수 있음.
         */
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("complete");
        log.info("future.complete(): {}", future.get());

        // CompletableFuture.completedFuture() 라는 Static Factory 메소드로 CompletableFuture 객체를 생성할 수 있음.
        future = CompletableFuture.completedFuture("completedFuture");
        log.info("CompletableFuture.completedFuture(): {}", future.get());
    }
}
