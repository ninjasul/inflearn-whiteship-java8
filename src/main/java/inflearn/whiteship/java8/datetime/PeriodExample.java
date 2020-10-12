package inflearn.whiteship.java8.datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@Slf4j
public class PeriodExample {
    public static void main(String[] args) {
        /**
         * Period는 Duration과 달리 사람용 기간을 계산할 때 사용
         */
        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2020, Month.JUNE, 27);

        // between(): 현재 날짜 - 대상 날짜 의 값임.
        Period period = Period.between(today, thisYearBirthday);
        log.info("Period.getDays(): {}", period.getDays());

        Period until = today.until(thisYearBirthday);
        log.info("Period.get(DAYS): {}", until.get(ChronoUnit.DAYS));
    }
}
