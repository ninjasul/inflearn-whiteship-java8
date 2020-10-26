package inflearn.whiteship.java8._11_datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Instant 는 주로 기계용 시간 표현 클래스임.
 */
@Slf4j
public class _03_InstantEx {
    public static void main(String[] args) {
        /**
         * UTC(Universal Time Coordinated), GMT(Greenwich Mean Time) 시간
         */
        Instant instant = Instant.now();
        log.info("instant: {}", instant);

        ZonedDateTime utcDateTime = instant.atZone(ZoneId.of("UTC"));
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());

        log.info("utcDateTime: {}", utcDateTime);
        log.info("zonedDateTime: {}", zonedDateTime);
    }
}
