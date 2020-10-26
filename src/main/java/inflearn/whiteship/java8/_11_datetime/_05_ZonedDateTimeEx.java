package inflearn.whiteship.java8._11_datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.*;

@Slf4j
public class _05_ZonedDateTimeEx {
    public static void main(String[] args) {
        /**
         * ZonedDateTime은 ZonedDateTime.now() 메소드로 생성 가능
         */
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        log.info("nowInKorea: {}", nowInKorea);

        /**
         * Instant 를 통해 ZonedDateTime 생성도 가능
         */
        Instant nowInstant = Instant.now();
        ZonedDateTime nowInstantDateTime = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        log.info("nowInstantDateTime: {}", nowInstantDateTime);

        /**
         * ZonedDateTime에서 LocalDateTime 으로 변환도 가능
         */
        LocalDateTime localDateTime = nowInstantDateTime.toLocalDateTime();
        log.info("localDateTime: {}", localDateTime);
    }
}
