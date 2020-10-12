package inflearn.whiteship.java8.datetime;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarProblem {
    public static void main(String[] args) {
        /**
         * GregorianCalendar의 문제점
         *  1. month를 int로 입력받게 되어 있는데, 1월은 0, 2월은 1 과 같이 배열 인덱스처럼 입력받게 되어 있음.
         *      버그가 발생할 소지가 다분함. 예를 들어 6월을 입력하고 싶으면 month란에 6대신 5를 입력해야 함.
         *  2. year, month, dayOfMonth 모두 int로 입력 받기 때문에 음수 입력도 가능하여 type-safe 하지 않음.
         */
        Calendar myBirthDay = new GregorianCalendar(1979, Calendar.JUNE, 27);

    }
}
