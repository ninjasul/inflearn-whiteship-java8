package inflearn.whiteship.java8._12_concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class _07_ThreadScheduledExecutor {
    public static void main(String[] args) {
        // ScheduledExecutor 는 예약 작업을 수행할 수 있는 ThreadPool 임.
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        // schedule() 메소드는 예약 작업을 한번만 수행하는 메소드임.
        // executorService.schedule(getRunnable("Hello schedule()"), 2, TimeUnit.SECONDS);
        //executorService.shutdown();

        // scheduleAtFixedRate() 은 주기적으로 예약 작업을 반복 수행하는 메소드임.
        // initialDelay: 최초 대기 시간
        // period: 반복 수행 주기
        // shutdown() 호출 시 종료되므로 호춣하면 안됨.
        executorService.scheduleAtFixedRate(getRunnable("Hello scheduleAtFixedRate()"), 1, 2, TimeUnit.SECONDS);
    }

    private static Runnable getRunnable(String message) {
        return () -> log.info("{} {}", message, Thread.currentThread().getName());
    }
}
