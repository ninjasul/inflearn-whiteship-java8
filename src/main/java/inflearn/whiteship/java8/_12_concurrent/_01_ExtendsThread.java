package inflearn.whiteship.java8._12_concurrent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class _01_ExtendsThread {
    public static void main(String[] args) {
        // Thread 를 상속받은 클래스를 선언한 뒤 run() 메소드를 구현
        new MyThread().start();
        log.info("Hello, {}", Thread.currentThread().getName());
    }

    @Slf4j
    static class MyThread extends Thread {
        @Override
        public void run() {
            log.info("Hello, {}", Thread.currentThread().getName());
        }
    }
}
