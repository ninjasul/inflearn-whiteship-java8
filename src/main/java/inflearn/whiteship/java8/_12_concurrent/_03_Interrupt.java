package inflearn.whiteship.java8._12_concurrent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class _03_Interrupt {
    public static void main(String[] args) throws InterruptedException {
        // Thread의 생성자에 runnable 인터페이스 구현
        Thread thread = new Thread(_03_Interrupt::run);

        log.info("Hello, {}", Thread.currentThread().getName());
        Thread.sleep(3000L);

        // interrupt() 메소드를 호출하면 해당 스레드는 InterruptedException 이 발생함.
        thread.interrupt();
    }

    public static void run() {
        while (true) {
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException e) {
                // run() 메소드는 void 타입이므로 return이 되면 해당 thread가 종료됨.
                log.error("", e);
                return;
            }
            log.info("Hello, {}", Thread.currentThread().getName());
        }
    }
}
