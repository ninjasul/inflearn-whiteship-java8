package inflearn.whiteship.java8._11_datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Slf4j
/**
 * Date 클래스의 문제점
 */
public class _01_DateAndTime {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 1. 네이밍: Date 클래스인데 time도 가져올 수 있다.
         * 2. time: 우리가 사용하는 일반적인 시간이 아닌 1970년 1월 1일부터 현재까지의 밀리세컨드임.
         */
        Date date = new Date();
        long time = date.getTime();
        log.info("{}", date);
        log.info("{}", time);

        /**
         * 3. Date는 mutable함: 값을 변경할 수 있으므로 thread safe하지 않음.
         */
        Thread.sleep(1000 * 3);
        Date after3Seconds = new Date();
        log.info("{}", after3Seconds);
        after3Seconds.setTime(time);
        log.info("{}", after3Seconds);
    }
}
