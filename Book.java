import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title, author, isbn, category, publisher;
    private int totalCopies, availableCopies;
    private List<String> reservedBy = new ArrayList<>();
    private Map<String, LocalDateTime> reservationNotifiedAt = new HashMap<>();

    public Book(String title, String author, String isbn, int copies) {
        this(title, author, isbn, copies, "General");
    }

    public Book(String title, String author, String isbn, int copies, String category) {
        this(title, author, isbn, copies, category, "");
    }

    public Book(String title, String author, String isbn, int copies, String category, String publisher) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.totalCopies = this.availableCopies = copies;
        this.category = category;
        this.publisher = publisher != null ? publisher : "";
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getCategory() {
        return category;
    }

    public String getPublisher() {
        return publisher != null ? publisher : "";
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public List<String> getReservedBy() {
        if (reservedBy == null)
            reservedBy = new ArrayList<>();
        return reservedBy;
    }

    public void setReservationNotified(String email) {
        if (reservationNotifiedAt == null)
            reservationNotifiedAt = new HashMap<>();
        reservationNotifiedAt.put(email, LocalDateTime.now());
    }

    public LocalDateTime getReservationNotifiedAt(String email) {
        if (reservationNotifiedAt == null)
            return null;
        return reservationNotifiedAt.get(email);
    }

    public void clearReservationNotified(String email) {
        if (reservationNotifiedAt != null)
            reservationNotifiedAt.remove(email);
    }

    public void setTitle(String v) {
        title = v;
    }

    public void setAuthor(String v) {
        author = v;
    }

    public void setIsbn(String v) {
        isbn = v;
    }

    public void setCategory(String v) {
        category = v;
    }

    public void setPublisher(String v) {
        publisher = v != null ? v : "";
    }

    public void setTotalCopies(int n) {
        availableCopies += (n - totalCopies);
        totalCopies = n;
        if (availableCopies < 0)
            availableCopies = 0;
    }

    public boolean issueBook() {
        if (availableCopies <= 0)
            return false;
        availableCopies--;
        return true;
    }

    public void returnBook() {
        if (availableCopies < totalCopies)
            availableCopies++;
    }

    public String getStatusTag() {
        if (availableCopies == 0)
            return "OUT OF STOCK";
        if (availableCopies <= 2)
            return "LOW STOCK";
        return "AVAILABLE";
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author +
                ", ISBN: " + isbn + ", Available: " + availableCopies + "/" + totalCopies;
    }
}
