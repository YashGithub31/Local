import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.Period;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Date utilDate = new Date();
        System.out.println("java.util.Date: " + utilDate);

        // Conversion to java.time.LocalDate

        // use toInstant() to obtain an Instant and then atZone() to convert it to the
        // desired time zone
        LocalDate localDateFromUtilDate = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("Converted to java.time.LocalDate: " + localDateFromUtilDate);

        // Conversion to java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println("Converted to java.sql.Date: " + sqlDate);

        // java.time.LocalDate
        LocalDate localDate = LocalDate.now();
        System.out.println("java.time.LocalDate: " + localDate);

        // Conversion to java.util.Date
        Date utilDateFromLocalDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println("Converted to java.util.Date: " + utilDateFromLocalDate);

        // Conversion to java.sql.Date
        java.sql.Date sqlDateFromLocalDate = java.sql.Date.valueOf(localDate);
        System.out.println("Converted to java.sql.Date: " + sqlDateFromLocalDate);

        // Arithmetic Operations
        LocalDate futureDate = localDate.plusDays(10);
        System.out.println("Future Date: " + futureDate);

        // Period between dates
        Period period = localDate.until(futureDate);
        int daysBetween = period.getDays();
        int monthsBetween = period.getMonths();
        int yearsBetween = period.getYears();
        System.out.println("Period between dates: " + yearsBetween + " years, " + monthsBetween + " months, "
                + daysBetween + " days");

        // Formatting Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(utilDate);
        System.out.println("Formatted Date: " + formattedDate);
    }
}
