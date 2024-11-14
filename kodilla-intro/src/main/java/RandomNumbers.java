import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumbers {
    List<Integer> numbers;

    public RandomNumbers() {
        numbers = new ArrayList<>();
    }

    public int sum() {
        int sum = 0;

        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }

        return sum;
    }

    public void fill() {
        Random rand = new Random();

        while (sum() <= 5000) {
            int randomNumber = rand.nextInt(31);
            System.out.println(randomNumber);
            numbers.add(randomNumber);
        }
    }

    public int getLargest() {
        int largest = -1;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > largest) {
                largest = numbers.get(i);
            }
        }

        return largest;
    }

    public int getSmallest() {
        int smallest;

        if (numbers.isEmpty()) {
            return -1;
        } else {
            smallest = numbers.getFirst();
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < smallest) {
                smallest = numbers.get(i);
            }
        }

        return smallest;
    }

    public static void main(String[] args) {
        RandomNumbers randomNumbers = new RandomNumbers();
        randomNumbers.fill();
        System.out.println(randomNumbers.sum());
        System.out.println(randomNumbers.getLargest());
        System.out.println(randomNumbers.getSmallest());
    }
}
