import java.util.Arrays;

public class Grades {
    private int[] grades;
    private int size;

    public Grades() {
        grades = new int[10];
        size = 0;
    }

    public void add(int value) {
        if (size == 10) {
            return;
        }

        grades[size] = value;
        size++;
    }

    public int getLastGrade() {
        if (size == 0) {
            return 0;
        }
        return grades[size-1];
    }

    public double calculateMean() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += grades[i];
        }

        return (double) sum / 10;
    }
}
