public class SimpleArray {
    public static void main(String[] args) {
        String[] books = new String[] {
            "The Black Prism",
            "The Blinding Knife",
            "The Broken Eye",
            "The Blood Mirror",
            "The Burning White",
        };

        String book = books[3];
        System.out.println(book);
        int bookCount = books.length;
        System.out.println("Moja tablica zawiera " + bookCount + " elementów");
    }
}