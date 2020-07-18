package se.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * create by ljs on 2020/7/2 21:06
 * description:
 */
public class LocalDateTimeDemo {

    public static void main(String[] args) {

        LocalDate d = LocalDate.now(); // 当前日期

        LocalTime t = LocalTime.now();  // 本地时间

        LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间



        System.out.println(d);
        System.out.println(t);
        System.out.println(dt);
    }

}
