package inflearn.whiteship.java8._11_datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.Month;

@Slf4j
public class _04_LocalDateTimeEx {
    public static void main(String[] args) {
        /**
         * LocalDateTime 은 현재 PC의 TimeZone 정보를 읽어서 현재 시각을 얻어옴.
         */
        LocalDateTime now = LocalDateTime.now();
        log.info("LocalDateTime now: {}", now);

        /**
         * .of() 메소드로 생성 가능
         */
        LocalDateTime birthDay = LocalDateTime.of(1979, Month.JUNE, 15, 17, 00, 00);
        log.info("LocalDateTime now: {}", birthDay);
    }
}
