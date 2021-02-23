package inflearn.whiteship.java8._12_concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class _06_FixedThreadPool {
    public static void main(String[] args) {
        // newFixedThreadPool 로 스레드 풀을 생성한 다음, 해당 스레드 풀 보다 많은 개수의 작업을 시키면
        // 나머지 작업은 BlockingQueue 에서 대기함.
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(getRunnable("Hello"));
        executorService.submit(getRunnable("ninjasul"));
        executorService.submit(getRunnable("Java"));
        executorService.submit(getRunnable("Runnable"));
        executorService.submit(getRunnable("Thread"));

        executorService.shutdown();
    }

    private static Runnable getRunnable(String message) {
        return () -> log.info("{} {}", message, Thread.currentThread().getName());
    }
}
