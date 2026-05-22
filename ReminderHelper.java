import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReminderHelper {
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("MMM dd, yyyy");

    public static String subject(String title, long days) {
        if (days < 0)  return "⚠ Overdue Book: \"" + title + "\"";
        if (days == 0) return "📅 Book Due Today: \"" + title + "\"";
        return "🔔 Return Reminder: \"" + title + "\"";
    }

    public static String overdueSubject(String title, int reminderNum) {
        return "⚠ Overdue Notice #" + reminderNum + ": \"" + title + "\"";
    }

    public static String body(String email, String title, LocalDate due, long days, String sign) {
        String greeting = "Dear " + email + ",\n\n";
        if (days < 0)
            return greeting + "Your borrowed book \"" + title + "\" was due on " + due.format(FMT) +
                   " and is now " + Math.abs(days) + " day(s) overdue.\n\nA fine of ৳" +
                   String.format("%.0f", Math.abs(days) * 5.0) + " has accumulated. Please return it soon.\n\n" + sign;
        if (days == 0)
            return greeting + "Your borrowed book \"" + title + "\" is due for return TODAY (" +
                   due.format(FMT) + ").\n\nPlease return it to avoid any fines.\n\n" + sign;
        return greeting + "Friendly reminder: \"" + title + "\" is due in " + days + " day(s) on " +
               due.format(FMT) + ".\n\nPlease return it on time to avoid a fine.\n\n" + sign;
    }

    public static String overdueBody(String email, String title, LocalDate due, long daysOverdue,
                                     int reminderNum, String sign) {
        long fine = Math.abs(daysOverdue) * 5L;
        String urgency;
        if (reminderNum == 1) urgency = "This is your first overdue notice.";
        else if (reminderNum == 2) urgency = "This is your second overdue notice.";
        else if (reminderNum == 3) urgency = "This is your third and final hourly notice. Further notices will be sent every 3 days.";
        else urgency = "This is overdue notice #" + reminderNum + ". Notices will continue every 3 days until the book is returned.";

        return "Dear " + email + ",\n\n" +
               "Your borrowed book \"" + title + "\" was due on " + due.format(FMT) +
               " and is now " + Math.abs(daysOverdue) + " day(s) overdue.\n\n" +
               "Accumulated fine: ৳" + fine + "\n\n" +
               urgency + "\n\n" +
               "Please return the book as soon as possible to stop further fines.\n\n" + sign;
    }
}
