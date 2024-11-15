public class Colors {
    public static String getFullColorName() {
        while (true) {
            String colorFirstLetter = UserDialogs.getValue();
            switch (colorFirstLetter.toLowerCase()) {
                case "g": return "green";
                case "b": return "blue";
                case "r": return "red";
                case "y": return "yellow";
                default:
                    System.out.println("Can't infer color's name from given letter. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Colors.getFullColorName());
    }
}
