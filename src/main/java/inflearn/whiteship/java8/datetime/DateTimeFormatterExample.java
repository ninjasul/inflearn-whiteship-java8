package inflearn.whiteship.java8.datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

@Slf4j
public class DateTimeFormatterExample {
    public static void main(String[] args) {
        /**
         * 1. DateTimeFormmater 를 이용한 포맷팅
         */
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter MMddyyyyFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter yyyyMMddHHmmssFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        log.info("{}", now.format(MMddyyyyFormatter));
        log.info("{}", now.format(yyyyMMddHHmmssFormatter));


        /**
         * 2. DateTimeFormatter 를 이용한 파싱
         */
        LocalDate parsedDate = LocalDate.parse("06/27/1979", MMddyyyyFormatter);
        log.info("{}", parsedDate);

        /**
         * 3. Date와 Instant 간 Conversion
         */
        Date date = new Date();
        Instant instant = date.toInstant();
        Date newDate = Date.from(instant);

        /**
         * 4. Calendar 와 LocalDateTime, ZonedDateTime 간 Conversion
         */
        Calendar calendar = new GregorianCalendar();
        LocalDateTime localDateTime = calendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        GregorianCalendar gregorianCalendar = GregorianCalendar.from(calendar.toInstant().atZone(ZoneId.systemDefault()));

        log.info("converted localDateTime: {}", localDateTime);
        log.info("converted gregorianCalendar: {}", gregorianCalendar);

        /**
         * TimeZone 과 TimeZone 간 Conversion
         */
        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);

        log.info("zoneId: {}", zoneId);
        log.info("timeZone: {}", timeZone.getID());
    }
}
