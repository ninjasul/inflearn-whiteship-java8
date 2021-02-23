package inflearn.whiteship.java8._12_concurrent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class _04_Join {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(_04_Join::run);
        thread.start();

        log.info("Hello, {}", Thread.currentThread().getName());

        // join() 메소드는 해당 스레드가 종료될 때 까지 동기적으로 기다림.
        thread.join();
        log.info("{} is finished.", thread.getName());
    }

    public static void run() {
        log.info("Hello, {}", Thread.currentThread().getName());
        try {
            Thread.sleep(3000L);
        }
        catch (InterruptedException e) {
            // run() 메소드는 void 타입이므로 return이 되면 해당 thread가 종료됨.
            log.error("", e);
            return;
        }
    }
}
