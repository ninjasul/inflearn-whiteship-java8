package inflearn.whiteship.java8._11_datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * Duration은 Instant(기계용 기간) 기간 표현 용.
 */
@Slf4j
public class _07_DurationEx {
    public static void main(String[] args) {
        Instant now = Instant.now();
        Instant after10Seconds = now.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now, after10Seconds);

        // between.getSeconds(): 10
        log.info("between.getSeconds(): {}", between.getSeconds());
    }
}
