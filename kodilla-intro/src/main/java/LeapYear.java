public class LeapYear {
    public static void main(String[] args) {
        System.out.println("1968: " + isLeapYear(1968));
        System.out.println("2000: " + isLeapYear(2000));
        System.out.println("2100: " + isLeapYear(2100));
        System.out.println("1999: " + isLeapYear(1999));

        System.out.println("1968: " + isLeapYearOneliner(1968));
        System.out.println("2000: " + isLeapYearOneliner(2000));
        System.out.println("2100: " + isLeapYearOneliner(2100));
        System.out.println("1999: " + isLeapYearOneliner(1999));
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    private static boolean isLeapYearOneliner(int year) {
        return year % 4 == 0 && !(year % 100 == 0 && year % 400 != 0);
    }
}
