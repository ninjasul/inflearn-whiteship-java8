package inflearn.whiteship.java8._12_concurrent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class _02_Runnable {
    public static void main(String[] args) throws InterruptedException {
        // Thread의 생성자에 runnable 인터페이스 구현
        new Thread(() -> log.info("Hello, {}", Thread.currentThread().getName())).start();
        log.info("Hello, {}", Thread.currentThread().getName());
    }
}
