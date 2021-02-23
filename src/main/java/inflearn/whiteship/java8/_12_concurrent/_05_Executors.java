package inflearn.whiteship.java8._12_concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class _05_Executors {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // submit() 메소드는 인자로 전달된 run() 메소드를 실행한 다음 대기를 함.
        // 따라서 명시적으로 shutdown() 메소드를 호출 해 주어야 함.
        executorService.submit(() -> {
            log.info("Thread: {}", Thread.currentThread().getName());
            try {
                Thread.sleep(2000L);
            }
            catch (InterruptedException e) {
                log.error("", e);
                return;
            }
        });

        // shutdown(): 진행 중인 작업이 끝날 때 까지 기다렸다가 종료. 일명 graceful shutdown
        executorService.shutdown();

        // shutdownNow(): 진행 중인 작업 종료 여부에 관계 없이 즉시 종료.
        // executorService.shutdownNow();
    }
}
