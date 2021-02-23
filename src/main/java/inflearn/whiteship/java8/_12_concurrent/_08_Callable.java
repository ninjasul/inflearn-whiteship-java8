package inflearn.whiteship.java8._12_concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class _08_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> callable = getCallable();

        testNormal(executorService, callable);
        testCancel(executorService, callable);

        executorService.shutdown();
    }

    private static void testNormal(ExecutorService executorService, Callable<String> callable) throws InterruptedException, ExecutionException {
        Future<String> helloFuture = executorService.submit(callable);

        // isDone() 메소드로 스레드 작업 종료 여부를 알 수 있음.
        log.info("testNormalStarted: isDone: {}, isCancelled: {}", helloFuture.isDone(), helloFuture.isCancelled());

        // Future의 get() 메소드는 블록킹 메소드임. 즉, 쓰레드 실행이 끝날 때 까지 기다림.
        String result = helloFuture.get();
        log.info("testNormalResult: {}", result);

        log.info("testNormalEnd: isDone: {}, isCancelled: {}", helloFuture.isDone(), helloFuture.isCancelled());
    }

    private static void testCancel(ExecutorService executorService, Callable<String> callable) {
        Future<String> helloFuture;


        helloFuture = executorService.submit(callable);

        // isDone() 메소드로 스레드 작업 종료 여부를 알 수 있음.
        log.info("testCancelStarted: isDone: {}, isCancelled: {}", helloFuture.isDone(), helloFuture.isCancelled());

        /**
         * cancel() 메소드로 스레드 작업을 취소할 수 있음.
         * 이때 취소한 작업은 종료 된 것으로 간주하기 때문에
         * isDone() 으로 확인하면 true 임.
         * 그리고 취소한 작업은 get() 으로 값을 얻어올 수 없음. get() 메소드를 호출하면 CancellationException이 발생함.
         */
        helloFuture.cancel(false);

/*
        result = helloFuture.get();
        log.info("result2: {}", result);
*/

        log.info("testCancelEnd: isDone: {}, isCancelled: {}", helloFuture.isDone(), helloFuture.isCancelled());
    }

    private static Callable<String> getCallable() {
        return () -> {
            Thread.sleep(2000L);
            return "Hello, Callable";
        };
    }
}
