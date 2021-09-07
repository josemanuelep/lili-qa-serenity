package co.com.webtest.certification.lili.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class CustomDate {

    private CustomDate() {
    }

    private static final String PATTERN_TO_CAST = "MMMM d yyyy";
    private static final String PATTERN_MONTH_YEAR = "MMMM yyyy";
    private static final String PATTERN_TO_CAST_FORMAT_TABLE = "MM/dd/yyyy";
    private static final String PATTERN_TO_CAST_FORMAT_TO_SEARCH = "MMMM d";
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(PATTERN_TO_CAST, Locale.ENGLISH);
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT1 = new SimpleDateFormat(PATTERN_TO_CAST_FORMAT_TABLE, Locale.ENGLISH);
    private static final SimpleDateFormat FORMAT_TO_SEARCH_ELEMENT = new SimpleDateFormat(PATTERN_TO_CAST_FORMAT_TO_SEARCH, Locale.ENGLISH);
    private static final SimpleDateFormat formatToMonthAndYear = new SimpleDateFormat(PATTERN_MONTH_YEAR, Locale.ENGLISH);

    public static String getDateToSearchElement(String date) throws ParseException {
        Date dateParsed = SIMPLE_DATE_FORMAT.parse(date);
        return FORMAT_TO_SEARCH_ELEMENT.format(dateParsed);
    }

    public static String getDateToMonthAndYear(String date) throws ParseException {
        Date dateParsed = SIMPLE_DATE_FORMAT.parse(date);
        return formatToMonthAndYear.format(dateParsed);
    }

    public static String getTodayAsTableFormat() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern(PATTERN_TO_CAST_FORMAT_TABLE);
        return myDateObj.format(myFormatObj);
    }

    public static String getDateAsTableFormat(String date) throws ParseException {
        Date dateParsed = SIMPLE_DATE_FORMAT.parse(date);
        return SIMPLE_DATE_FORMAT1.format(dateParsed);
    }

    public static String getYesterdayAsTableFormat() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern(PATTERN_TO_CAST_FORMAT_TABLE);
        return myDateObj.minus(1, ChronoUnit.DAYS).withHour(0).withMinute(0)
                .withSecond(0).format(myFormatObj);
    }

    public static List<String> getDaysOfThisWeek() {
        Calendar now = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(PATTERN_TO_CAST_FORMAT_TABLE);
        List<String> dateListWeek = new ArrayList<>();
        int delta = -now.get(GregorianCalendar.DAY_OF_WEEK) + 2;
        now.add(Calendar.DAY_OF_MONTH, delta);
        for (int i = 0; i < 7; i++) {
            dateListWeek.add(format.format(now.getTime()));
            now.add(Calendar.DAY_OF_MONTH, 1);
        }
        return dateListWeek;
    }

}
