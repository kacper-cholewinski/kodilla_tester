public class Loops {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }

        String[] names = new String[] {"Zygfryd", "Gwidon", "Florentyna"};

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        System.out.println(sum(new int[] {1, 1, 2, 3, 5, 8, 13}));

        int i = 0;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }
    }

    private static int sum(int[] numbers) {
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return sum;
    }
}
