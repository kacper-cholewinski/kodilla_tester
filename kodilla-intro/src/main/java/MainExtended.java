import java.time.LocalDate;

public class MainExtended {
    public static void main(String[] args) {
        String bookTitle = "The Name of the Wind";
        String bookAuthor = "Patrick Rothfuss";
        int numberOfPages = 662;
        double rating = 4.52;
        boolean completed = true;
        LocalDate releaseDate = LocalDate.of(2007, 3, 27);

        System.out.println(bookTitle);
        System.out.println(bookAuthor);
        System.out.println(numberOfPages);
        System.out.println(rating);
        System.out.println(completed);
        System.out.println(releaseDate);
    }
}
