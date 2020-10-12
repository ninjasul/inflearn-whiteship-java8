package inflearn.whiteship.java8.datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Slf4j
public class DateAndTime {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 1. Date 클래스의 문제점
         *      1.1 네이밍: Date 클래스인데 time도 가져올 수 있다.
         *      1.2 time: 우리가 사용하는 일반적인 시간이 아닌 1970년 1월 1일부터 현재까지의 밀리세컨드임.
         */
        Date date = new Date();
        long time = date.getTime();
        log.info("{}", date);
        log.info("{}", time);

        /**
         *      1.3 Date는 mutable함: 값을 변경할 수 있으므로 thread safe하지 않음.
         */
        Thread.sleep(1000 * 3);
        Date after3Seconds = new Date();
        log.info("{}", after3Seconds);
        after3Seconds.setTime(time);
        log.info("{}", after3Seconds);

        /**
         * 2. GregorianCalendar의 문제점
         *  2.1. month를 int로 입력받게 되어 있는데, 1월은 0, 2월은 1 과 같이 배열 인덱스처럼 입력받게 되어 있음.
         *      버그가 발생할 소지가 다분함. 예를 들어 6월을 입력하고 싶으면 month란에 6대신 5를 입력해야 함.
         *  2.2. year, month, dayOfMonth 모두 int로 입력 받기 때문에 음수 입력도 가능하여 type-safe 하지 않음.
         */
        Calendar myBirthDay = new GregorianCalendar(1979, Calendar.JUNE, 27);


        /**
         * UTC(Universal Time Coordinated), GMT(Greenwich Mean Time) 시간
         */
        Instant instant = Instant.now();
        log.info("instant: {}", instant);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("UTC"));
    }
}
