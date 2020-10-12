package inflearn.whiteship.java8.datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Slf4j
public class DurationExample {
    public static void main(String[] args) {
        /**
         * Duration 은 Period와 달리 Machine 용 기간을 계산할 때 사용.
         */
        Instant now = Instant.now();
        Instant next = now.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now, next);

        // between.getSeconds(): 10
        log.info("between.getSeconds(): {}", between.getSeconds());
    }
}
