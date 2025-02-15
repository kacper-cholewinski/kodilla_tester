package fizz_buzz_game;

public class FizzBuzzGame {
    public static String checkForNumber(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        }

        if (number % 3 == 0) {
            return "Fizz";
        }

        if (number % 5 == 0) {
            return "Buzz";
        }

        return "None";
    }
}
